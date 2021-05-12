package com.zzu.hezhifeng.common.base.service;

import com.google.common.base.Optional;
import com.zzu.hezhifeng.common.base.dao.AbstractDAO;
import com.zzu.hezhifeng.common.base.pojo.BaseDO;
import com.zzu.hezhifeng.common.base.pojo.BaseParam;
import com.zzu.hezhifeng.common.base.pojo.BaseVO;
import com.zzu.hezhifeng.common.exceptions.ServiceException;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class AbstractDVService<ID extends Serializable,D extends BaseDO, V extends BaseVO, P extends BaseParam> {

    public ArrayList<V> list(P param) {
        Assert.notNull(param, "PARAM_IS_NULL");
        return this.getDAO().list(param);
    }

    @Transactional(
            isolation = Isolation.READ_COMMITTED,
            rollbackFor = {RuntimeException.class, ServiceException.class}
    )
    public ID insert(V vo) throws ServiceException {
        Long res = this.getDAO().insert(vo);
        if (res > 0) {
            return (ID) res;
        }
        throw new ServiceException("insert failed , maybe the vo is error");
    }

    @Transactional(
            isolation = Isolation.READ_COMMITTED,
            rollbackFor = {RuntimeException.class, ServiceException.class}
    )
    public void delete(V vo) throws ServiceException {
        Optional<V> optional = this.find((ID) vo.getId());
        if (optional.isPresent()){
            this.getDAO().delete(vo);
        }
        throw new ServiceException("delete failed , maybe the vo is not exists");
    }

    @Transactional(
            isolation = Isolation.READ_COMMITTED,
            rollbackFor = {RuntimeException.class, ServiceException.class}
    )
    public void update(V vo) throws ServiceException {
        Optional<V> optional = this.find((ID) vo.getId());
        if (optional.isPresent()){
            this.getDAO().update(vo);
        }
        throw new ServiceException("update failed , maybe the vo is not exists");
    }

    public Optional<V> find(ID id){
        Assert.notNull(id, "ID_IS_NULL");
        final BaseParam param = new BaseParam();
        param.setId((Long) id);
        ArrayList<V> list = this.getDAO().list(param);
        if (CollectionUtils.isNotEmpty(list)){
            return Optional.of(list.get(0));
        }
        return Optional.absent();
    }

    public Long count(P param){
        Assert.notNull(param, "PARAM_IS_NULL");
        return this.getDAO().count(param);
    }

    public abstract AbstractDAO getDAO();
}
