package com.zzu.hezhifeng.common.base.service;

import com.google.common.base.Optional;
import com.zzu.hezhifeng.common.base.dao.AbstractDAO;

import java.util.ArrayList;

/**
 * service的基类，可以实现基本的增删改查服务
 */
public interface AbstractService<D, V, P> {
    /**
     * 向数据库中增添一个元素
     * @param data
     * @return
     */
    Long insert(V data);

    /**
     * 从数据库中国删除一个元素
     * @param data
     */
    void delete(V data);

    /**
     * 从数据库中更新一个元素
     * @param data
     */
    void update(V data);

    /**
     * 查找数据库中的元素
     * @param param
     * @return
     */
    Optional<V> find(P param);

    /**
     * 查找所有元素
     * @param param
     * @return
     */
    ArrayList<V> list(P param);
}
