package com.zzu.hezhifeng.common.netty.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class ServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {

    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        // channel被注册并且产生流量时使用
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {

    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {

    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {

    }

    @Override
    public void channelWritabilityChanged(ChannelHandlerContext ctx) throws Exception {

    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {

    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {

    }

//    @Override
//    protected void channelRead0(ChannelHandlerContext channelHandlerContext, HttpObject httpObject) throws Exception {
//        if (httpObject instanceof HttpRequest){
//            HttpRequest reqObj = (HttpRequest)httpObject;
//            String clientIp = reqObj.headers().get("X-Forwarded-For");
//            ChannelName channelName = new ChannelName();
//            channelName.setIp(clientIp);
//            // 当channel中读取到数据时，将新增到channel添加到channelMap中进行管理
//            if (ChannelMap.getChannelByChannelName(channelName) != null){
//                ChannelMap.addChannel(channelName, channelHandlerContext.channel());
//            }
//            //TODO：处理读到的数据
//        }
//    }


}
