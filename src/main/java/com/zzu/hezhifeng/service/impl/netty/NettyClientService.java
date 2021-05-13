package com.zzu.hezhifeng.service.impl.netty;

import com.zzu.hezhifeng.service.impl.netty.common.Message;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;

import java.util.ArrayList;

public interface NettyClientService {

    /**
     * netty  Client init
     */
    Bootstrap init();

    ArrayList<Message> getHistoryMsg(Long clientId);

    /**
     * 发送消息
     * @param channel 向某个channel 发送消息
     * @param msg
     */
    void sendMsg(Channel channel, String msg);
}
