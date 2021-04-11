package com.zzu.hezhifeng.common.base.service.impl;

import com.google.common.base.Optional;
import com.zzu.hezhifeng.common.base.dao.AbstractDAO;
import com.zzu.hezhifeng.common.base.pojo.BaseDO;
import com.zzu.hezhifeng.common.base.pojo.BaseParam;
import com.zzu.hezhifeng.common.base.pojo.BaseVO;
import com.zzu.hezhifeng.common.base.service.AbstractService;

import java.util.ArrayList;

/**
 * service的基类，可以实现基本的增删改查服务
 */
public abstract class AbstractServiceImpl<D extends BaseDO, V extends BaseVO, P extends BaseParam> implements AbstractService<D, V, P> {

    @Override
    public Long insert(V data) {
        Long insert = this.getDAO().insert(data);
        return insert;
    }

    @Override
    public void delete(V data) {
        this.getDAO().delete(data);
    }

    @Override
    public void update(V data) {
        this.getDAO().update(data);
    }

    @Override
    public Optional<V> find(P param) {
        Optional<V> optional = this.getDAO().find(param);
        return optional;
    }

    @Override
    public ArrayList<V> list(P param) {
        ArrayList<V> list = this.getDAO().list(param);
        return list;
    }

}
