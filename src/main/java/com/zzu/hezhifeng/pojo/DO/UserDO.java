package com.zzu.hezhifeng.pojo.DO;

import com.zzu.hezhifeng.common.base.pojo.BaseDO;

import java.util.Date;

/**
 * 用户实体
 */
public class UserDO extends BaseDO {
    /**
     * 用户名
     */
    String name;
    /**
     * 用户登陆密码
     */
    String password;
    /**
     * 用户性别
     */
    String sex;
    /**
     * 用户工作空间code
     */
    String code;
    /**
     * 用户生日
     */
    Date birthday;
    /**
     * 用户注册时间
     */
    Date gmtCreate;
    /**
     * 记录修改时间
     */
    Date gmdModified;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmdModified() {
        return gmdModified;
    }

    public void setGmdModified(Date gmdModified) {
        this.gmdModified = gmdModified;
    }

    @Override
    public String toString() {
        return "User{" +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", code='" + code + '\'' +
                ", birthday=" + birthday +
                ", gmtCreate=" + gmtCreate +
                ", gmdModified=" + gmdModified +
                '}';
    }
}
