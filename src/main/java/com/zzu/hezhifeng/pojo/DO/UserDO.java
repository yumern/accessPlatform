package com.zzu.hezhifeng.pojo.DO;

import com.zzu.hezhifeng.common.base.pojo.BaseDO;
import com.zzu.hezhifeng.common.base.pojo.BaseVO;
import lombok.Data;

@Data
public class UserDO extends BaseDO {
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
