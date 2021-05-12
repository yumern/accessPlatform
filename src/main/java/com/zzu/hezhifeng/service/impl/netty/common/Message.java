package com.zzu.hezhifeng.service.impl.netty.common;

import lombok.Data;

import java.util.Date;

@Data
public class Message {
    /**
     * 客户端ID
     */
    private Long clientId;
    /**
     * 通信建立时间
     */
    private Date createTime;
    /**
     * 通信建立时间
     */
    private String msg;

}
