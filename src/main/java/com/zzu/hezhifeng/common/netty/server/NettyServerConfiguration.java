package com.zzu.hezhifeng.common.netty.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetSocketAddress;


@Configuration
public class NettyServerConfiguration {

    @Bean
    public ServerBootstrap serverBootstrap() throws InterruptedException {
        //1、创建服务对象
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        // 2.创建两个线程池 第一个监听端口号 nio监听
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        // 3.将线程池放入工程
        serverBootstrap.group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_SNDBUF, 32 * 1024)
                .option(ChannelOption.SO_RCVBUF, 32 * 1024)
                .childOption(ChannelOption.SO_KEEPALIVE, true)
                //使用匿名内部类的形式初始化通道对象
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        socketChannel.pipeline().addLast(new ServerHandler())
                                                .addLast(new StringDecoder());
                    }
                });
        //给workerGroup的EventLoop对应的管道设置处理器
        // 绑定端口号
        ChannelFuture channelFuture = serverBootstrap.bind(new InetSocketAddress(8080)).sync();
        channelFuture.channel().closeFuture().sync();
        bossGroup.shutdownGracefully();
        workerGroup.shutdownGracefully();
        System.out.println("服务器端已经启动");
        return serverBootstrap;
    }
}
