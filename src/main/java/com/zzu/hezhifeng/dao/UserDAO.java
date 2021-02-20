package com.zzu.hezhifeng.dao;

import com.zzu.hezhifeng.pojo.DO.User;
import com.zzu.hezhifeng.pojo.Param.UserParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Mapper
public interface UserDAO{
    /**
     * 插入一条记录
     * @param user
     * @return
     */
    Long insert(@Param("data") User user);

    /**
     * 修改一条记录
     * @param user
     */
    void update(@Param("data") User user);

    /**
     * 删除一条记录
     * @param user
     */
    void delete(@Param("data") User user);

    /**
     * 查询记录
     * @param user
     * @return
     */
    ArrayList<User> list(@Param("param") UserParam user);

    Long count(@Param("param") User user);
}
