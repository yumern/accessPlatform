package com.zzu.hezhifeng.pojo.Param;

import com.zzu.hezhifeng.common.base.pojo.BaseParam;
import lombok.Data;

@Data
public class ProjectParam extends BaseParam {
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
