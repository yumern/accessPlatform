package com.zzu.hezhifeng.common.netty.server;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.zzu.hezhifeng.pojo.DO.DataObj;
import com.zzu.hezhifeng.pojo.Param.ProjectParam;
import com.zzu.hezhifeng.pojo.Param.ProjectRecordParam;
import com.zzu.hezhifeng.pojo.Param.UserParam;
import com.zzu.hezhifeng.pojo.VO.HistoryRecordVO;
import com.zzu.hezhifeng.pojo.VO.ProjectRecordVO;
import com.zzu.hezhifeng.service.UserService;
import com.zzu.hezhifeng.service.history.HistoryRecordService;
import com.zzu.hezhifeng.service.project.ProjectRecordService;
import com.zzu.hezhifeng.service.project.ProjectService;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.*;

@Component
@Scope("prototype")
public class ServerHandler extends ChannelInboundHandlerAdapter {
    @Autowired
    private ProjectRecordService recordService;
    @Autowired
    private HistoryRecordService historyRecordService;
    @Autowired
    private ProjectService projectService;
    @Autowired
    private UserService userService;

    private static HashMap<Channel, Long> myChannelMap = Maps.newHashMap();
    String message;

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("registered"+ ctx.channel().remoteAddress());
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("unregistered"+ ctx.channel().remoteAddress());
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("active"+ ctx.channel().remoteAddress());
        // channel被注册并且产生流量时使用
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {

    }

    /**
     * 处理接收到的数据中包含中文时的乱码问题
     * @param buf
     * @return
     */
    private String getMessage(ByteBuf buf){
        byte[] con = new byte[buf.readableBytes()];
        buf.readBytes(con);
        try {
            return new String(con, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ByteBuf byteBuf = (ByteBuf) msg;
        try {
            message = this.getMessage(byteBuf);
            System.out.println(message);
        } finally {
            ReferenceCountUtil.release(msg);
        }
    }

    /**
     * 检验channel是否存在
     * @param channel
     * @return
     */
    Boolean checkChannelStatus(Channel channel){
        for (Channel ch : myChannelMap.keySet()){
            if (ch.remoteAddress().equals(channel.remoteAddress())){
                return true;
            }
        }
        return false;
    }

    /**
     * 根据项目id与秘钥进行验证秘钥合法性
     * @param projectId
     * @param secretKey
     * @return
     */
    Boolean checkSecretKey(Long projectId, String secretKey){
        ProjectParam param = new ProjectParam();
        param.setId(projectId);
        Long userId = projectService.find(param).get().getUserId();
        UserParam userParam = new UserParam();
        userParam.setId(userId);
        String realSecretKey = userService.find(userParam).get().getSecretKey();
        if (secretKey.equals(realSecretKey)){
            return true;
        }
        return false;
    }

    /**
     * 添加通信记录
     * @param recordVO
     * @param res
     */
    void addLog(ProjectRecordVO recordVO, Integer res){
        HistoryRecordVO historyRecordVO = new HistoryRecordVO();
        historyRecordVO.setRecordId(recordVO.getId());
        historyRecordVO.setRes(res);
        historyRecordVO.setGmtCreate(new Date());
        historyRecordVO.setConfig(JSONObject.toJSONString(recordVO));
        historyRecordService.insert(historyRecordVO);
    }

    /**
     * 根据消息获取监听记录
     * @param dataObj
     * @return
     */
    ProjectRecordVO getRecordByMsg(DataObj dataObj){
        Long projectId = dataObj.getUid();
        ProjectRecordVO message = dataObj.getMessage();
        message.setProjectId(projectId);
        ProjectRecordParam recordParam = new ProjectRecordParam();
        BeanUtils.copyProperties(message, recordParam);
        ArrayList<ProjectRecordVO> list = recordService.list(recordParam);
        if (CollectionUtils.isNotEmpty(list)){
            return list.get(0);
        }
        return null;
    }

    /**
     * 根据ip与端口获取其对应的channel
     * @param ip
     * @param port
     * @return
     */
    Channel getChannelByIp(String ip, Integer port){
        Set<Channel> values = myChannelMap.keySet();
        SocketAddress address = new InetSocketAddress(ip, port);
        for (Channel channel : values){
            if (values.equals(channel.remoteAddress())){
                return channel;
            }
        }
        return null;
    }
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        System.out.println("complete" + ctx.channel().remoteAddress());
        try {
            DataObj data = JSONObject.parseObject(message, DataObj.class);
            String secretKey = data.getSecretKey();
            Long uid = data.getUid();
            if (this.checkSecretKey(uid, secretKey)) {
                if (!checkChannelStatus(ctx.channel())) {
                    myChannelMap.put(ctx.channel(), uid);
                }
                //根据projectId + key + value 找到targetIp 与 detail
                Integer res = 0;
                ProjectRecordVO recordVO = this.getRecordByMsg(data);
                if (!Objects.isNull(recordVO)) {
                    String targetIp = recordVO.getTargetIp();
                    String targetPort = recordVO.getTargetPort();
                    Channel targetChannel = this.getChannelByIp(targetIp, Integer.parseInt(targetPort));
                    if (Objects.isNull(targetChannel)) {
                        targetChannel.writeAndFlush(Unpooled.copiedBuffer(JSONObject.toJSONString(data.getMessage()).getBytes(StandardCharsets.UTF_8)));
                        res = 1;
                    } else {
                        res = 0;
                    }
                    this.addLog(recordVO, res);
                }
            }
        }
        catch (Exception e){
            System.out.println("\n parse failed");
            return;
        }

    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        System.out.println("userEventTriggered"+ ctx.channel().remoteAddress());
    }

    @Override
    public void channelWritabilityChanged(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channelWritabilityChanged"+ ctx.channel().remoteAddress());
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        System.out.println("handlerAdded"+ ctx.channel().remoteAddress());
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        System.out.println("handlerRemoved"+ ctx.channel().remoteAddress());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {

    }

}
