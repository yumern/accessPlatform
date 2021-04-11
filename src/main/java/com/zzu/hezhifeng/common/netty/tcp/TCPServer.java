package com.zzu.hezhifeng.common.netty.tcp;

import com.alibaba.fastjson.JSONObject;
import com.zzu.hezhifeng.pojo.DO.DataObj;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Configuration
public class TCPServer {
    @Value("8080")
    private Integer port;

    @Bean("tcpServer")
    public void server() throws IOException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        AsynchronousChannelGroup asynchronousChannelGroup = AsynchronousChannelGroup.withThreadPool(executorService);
        AsynchronousServerSocketChannel socketChannel = AsynchronousServerSocketChannel.open(asynchronousChannelGroup);
        socketChannel.bind(new InetSocketAddress(port));
        System.out.println(String.format("server: %s init ……" ,socketChannel.getLocalAddress().toString()));
        socketChannel.accept(socketChannel, new MyHandler());
        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    public DataObj readMsg(AsynchronousSocketChannel channel) throws IOException {
        ByteBuffer echoBuffer = ByteBuffer.allocate(1024*5);
        CharsetDecoder decoder= Charset.forName("UTF-8").newDecoder();

        channel.read(echoBuffer);
        echoBuffer.flip();
        String input = new String(echoBuffer.array(),0,echoBuffer.limit());
        //拿到源地址 + massage 后
        DataObj data = JSONObject.parseObject(input, DataObj.class);
        return data;
    }

    public void writeMsg(String ip, Integer port, String msg) throws IOException {
        Socket socket = new Socket(ip, port);
        OutputStream os = socket.getOutputStream();
        os.write(msg.getBytes());
        os.close();
    }
}
