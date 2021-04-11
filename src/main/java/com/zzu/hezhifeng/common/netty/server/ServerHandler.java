package com.zzu.hezhifeng.common.netty.server;

import com.alibaba.fastjson.JSONObject;
import com.zzu.hezhifeng.pojo.DO.DataObj;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class ServerHandler extends ChannelInboundHandlerAdapter {
    // 接收到的消息的格式
    DataObj msgObj = new DataObj();

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

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ByteBuf byteBuf = (ByteBuf) msg;
        String message = "";
        try {
            while (byteBuf.isReadable()){
                message += (char)byteBuf.readByte();
                System.out.print((char) byteBuf.readByte());
                System.out.flush();
            }
           try {
               msgObj = JSONObject.parseObject(message, DataObj.class);
           } catch (Exception e){
               return;
           }

        } finally {
            ReferenceCountUtil.release(msg);
        }
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        System.out.println("complete" + ctx.channel().remoteAddress());
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024 * 5);
        ctx.channel().writeAndFlush(Unpooled.copiedBuffer("你好".getBytes(StandardCharsets.UTF_8)));
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
