package com.zzu.hezhifeng.service;

import com.zzu.hezhifeng.pojo.DO.User;
import com.zzu.hezhifeng.pojo.Param.UserParam;

import java.util.ArrayList;
import java.util.Optional;

/**
 * user数据库的服务接口
 */
public interface UserService<D>{
    /**
     * 查找数据
     * @param user
     * @return
     */
    ArrayList<User> list(UserParam user);

    /**
     * 更新数据
     * @param user
     */
    void update(User user);

    /**
     * 根据id获取元素
     * @param id
     * @return
     */
    Optional<D> find(Long id);

    /**
     * 插入一条数据
     * @param user
     * @return
     */
    Long insert(User user);

    /**
     * 删除一条数据
     * @param user
     */
    void delete(User user);
}
