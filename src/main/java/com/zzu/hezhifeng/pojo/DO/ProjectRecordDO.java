package com.zzu.hezhifeng.pojo.DO;

import com.zzu.hezhifeng.common.base.pojo.BaseDO;
import com.zzu.hezhifeng.common.base.pojo.BaseVO;
import lombok.Data;

@Data
public class ProjectRecordDO extends BaseDO {
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
     * 匹配数值
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
}
