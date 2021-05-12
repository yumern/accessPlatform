package com.zzu.hezhifeng.pojo.DO;

import com.zzu.hezhifeng.common.base.pojo.BaseDO;
import com.zzu.hezhifeng.common.base.pojo.BaseVO;
import lombok.Data;

@Data
public class HistoryRecordDO extends BaseDO {
    /**
     * 命中规则id
     */
    private Long recordId;
    /**
     * 所属项目id
     */
    private Long projectId;
    /**
     * 监听ip
     */
    private String listenIp;
    /**
     * 监听字段
     */
    private String listenKey;
    /**
     * 匹配值
     */
    private String matchValue;
    /**
     * 转发ip
     */
    private String targetIp;
    /**
     * 转发端口
     */
    private String targetPort;
    /**
     * 补充数据
     */
    private String detail;
    /**
     * 通信结果:
     *  1、成功
     *  2、失败
     */
    private Integer res;
    /**
     * 通信快照
     */
    private String config;
}
