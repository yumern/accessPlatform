package com.zzu.hezhifeng.service.permission.impl;

import com.google.common.base.Optional;
import com.zzu.hezhifeng.common.base.dao.AbstractDAO;
import com.zzu.hezhifeng.common.base.service.AbstractDVService;
import com.zzu.hezhifeng.common.base.service.AbstractService;
import com.zzu.hezhifeng.common.exceptions.ServiceException;
import com.zzu.hezhifeng.dao.UserDAO;
import com.zzu.hezhifeng.pojo.DO.UserDO;
import com.zzu.hezhifeng.pojo.Param.UserParam;
import com.zzu.hezhifeng.pojo.VO.UserVO;
import com.zzu.hezhifeng.service.permission.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PermissionServiceImpl extends AbstractDVService<Long, UserDO, UserVO, UserParam> implements PermissionService {
    @Autowired
    private UserDAO userDAO;

    @Override
    public Long insert(UserVO data) throws ServiceException {
        return super.insert(data);
    }

    @Override
    public void delete(UserVO data) throws ServiceException {
        super.delete(data);
    }

    @Override
    public void update(UserVO data) throws ServiceException {
        super.update(data);
    }

    @Override
    public Optional<UserVO> find(Long id) {
        return super.find(id);
    }

    @Override
    public ArrayList<UserVO> list(UserParam param) {
        return super.list(param);
    }

    @Override
    public AbstractDAO getDAO() {
        return this.userDAO;
    }
}
