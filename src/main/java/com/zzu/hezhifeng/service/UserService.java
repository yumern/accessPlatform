package com.zzu.hezhifeng.service;

import com.zzu.hezhifeng.pojo.DO.UserDO;
import com.zzu.hezhifeng.pojo.Param.UserParam;

import java.util.ArrayList;
import com.google.common.base.Optional;

/**
 * user数据库的服务接口
 */
public interface UserService{
    /**
     * 查找数据
     * @param user
     * @return
     */
    ArrayList<UserDO> list(UserParam user);

    /**
     * 更新数据
     * @param userDO
     */
    void update(UserDO userDO);

    /**
     * 根据id获取元素
     * @param id
     * @return
     */
    Optional<UserDO> find(Long id);

    /**
     * 插入一条数据
     * @param userDO
     * @return
     */
    Long insert(UserDO userDO);

    /**
     * 删除一条数据
     * @param userDO
     */
    void delete(UserDO userDO);
}
