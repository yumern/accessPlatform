package com.zzu.hezhifeng.pojo.DO;

import com.zzu.hezhifeng.common.base.pojo.BaseDO;
import com.zzu.hezhifeng.common.base.pojo.BaseVO;
import lombok.Data;

@Data
public class ProjectDO extends BaseDO {
    /**
     * 项目所属用户id
     */
    private Long userId;
    /**
     * 项目名称
     */
    private String name;
    /**
     * 项目描述
     */
    private String description;
    /**
     * 项目监听ip
     */
    private String listenIp;
}
