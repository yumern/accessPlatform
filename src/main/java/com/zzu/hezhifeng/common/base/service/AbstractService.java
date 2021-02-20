package com.zzu.hezhifeng.common.base.service;

import java.util.ArrayList;
import java.util.Optional;

/**
 * service的基类，可以实现基本的增删改查服务
 */
public interface AbstractService<D, V, P> {
    /**
     * 向数据库中增添一个元素
     * @param data
     * @return
     */
    Long insert(D data);

    /**
     * 从数据库中国删除一个元素
     * @param data
     */
    void delete(D data);

    /**
     * 从数据库中更新一个元素
     * @param data
     */
    void update(D data);

    /**
     * 查找数据库中的元素
     * @param param
     * @return
     */
    Optional<D> find(P param);

    /**
     * 查找所有元素
     * @param param
     * @return
     */
    ArrayList<D> list(P param);
}
