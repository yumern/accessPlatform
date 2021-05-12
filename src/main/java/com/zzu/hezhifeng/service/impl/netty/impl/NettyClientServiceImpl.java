package com.zzu.hezhifeng.service.impl.netty.impl;


import com.zzu.hezhifeng.service.impl.netty.NettyClientService;
import com.zzu.hezhifeng.service.impl.netty.common.ClientHandler;
import com.zzu.hezhifeng.service.impl.netty.common.Message;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class NettyClientServiceImpl implements NettyClientService {

    @Value("${netty.server.ip}")
    private String ip;
    @Value(("${server.port}"))
    private Integer port;


    @Override
    public Bootstrap init() {
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new StringDecoder());
                        ch.pipeline().addLast(new ClientHandler());
                    }
                });
        return bootstrap;
    }

    @Override
    public ArrayList<Message> getHistoryMsg(Long clientId) {
        return null;
    }

    @Override
    public void sendMsg(Channel channel, String msg) {
        NioEventLoopGroup pGroup = new NioEventLoopGroup();
        Bootstrap bootstrap = this.init();
        ChannelFuture cf = bootstrap.bind(ip, port);
        cf.channel().writeAndFlush(Unpooled.wrappedBuffer(msg.getBytes()));
        cf.channel().closeFuture();
        pGroup.shutdownGracefully();
    }
}
