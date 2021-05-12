package com.zzu.hezhifeng.pojo.Param;

import com.zzu.hezhifeng.common.base.pojo.BaseParam;
import lombok.Data;

@Data
public class UserParam extends BaseParam {
    /**
     * 用户名
     */
    private String userName;
    /**
     * 登陆密码
     */
    private String password;
    /**
     * 联系方式
     */
    private String phone;
    /**
     * 认证秘钥
     */
    private String secretKey;
}
