package com.zzu.hezhifeng.common.netty.tcp;

import com.alibaba.fastjson.JSONObject;
import com.zzu.hezhifeng.pojo.DO.DataObj;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MyHandler implements CompletionHandler<AsynchronousSocketChannel, AsynchronousServerSocketChannel> {
    ByteBuffer echoBuffer = ByteBuffer.allocate(1024*5);
    CharsetDecoder decoder= Charset.forName("UTF-8").newDecoder();
    //读数据成功
    @Override
    public void completed(AsynchronousSocketChannel result, AsynchronousServerSocketChannel attachment) {
        echoBuffer.clear();
        //读取数据到echoBuffer中
        result.read(echoBuffer);
        echoBuffer.flip();
        String input = new String(echoBuffer.array(),0,echoBuffer.limit());
        DataObj dataObj = JSONObject.parseObject(input, DataObj.class);
        //处理读到的数据
        try {
            SocketAddress remoteAddress = result.getRemoteAddress();
            //获取消息来源，判断是否有权限操纵数据 -- 通过项目名称，认证密码，转发IP
            if (check(remoteAddress)){
                List<String> collect = Arrays.stream(dataObj.getSourceAddress().split(":")).collect(Collectors.toList());
                InetSocketAddress targetAddress = new InetSocketAddress(collect.get(0), Integer.parseInt(collect.get(1)));
                result.connect(targetAddress);
                echoBuffer.clear();
                echoBuffer.put(dataObj.getMessage().getBytes(StandardCharsets.UTF_8));
                result.write(echoBuffer);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //读数据失败
    @Override
    public void failed(Throwable exc, AsynchronousServerSocketChannel attachment) {

    }

    public Boolean check(SocketAddress remoteAddress){
        return true;
    }
}
