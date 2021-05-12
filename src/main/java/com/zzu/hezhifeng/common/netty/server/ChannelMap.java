package com.zzu.hezhifeng.common.netty.server;

import io.netty.channel.Channel;

import java.util.concurrent.ConcurrentHashMap;


public class ChannelMap {
    private static ConcurrentHashMap<ChannelName, Channel> channelNameMap = new ConcurrentHashMap<>();

    public static void addChannel(ChannelName name, Channel channel){
        channelNameMap.put(name, channel);
    }
    public static void delChannel(ChannelName name){
        if (channelNameMap.containsKey(name)){
            channelNameMap.remove(name);
        }
    }
    public static Channel getChannelByChannelName(ChannelName name){
        return channelNameMap.get(name);
    }
}
