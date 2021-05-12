package com.zzu.hezhifeng.service.impl;

import com.google.common.base.Optional;
import com.zzu.hezhifeng.dao.UserDAO;
import com.zzu.hezhifeng.pojo.DO.UserDO;
import com.zzu.hezhifeng.pojo.Param.UserParam;
import com.zzu.hezhifeng.pojo.VO.UserVO;
import com.zzu.hezhifeng.service.UserService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;


    @Override
    public Long insert(UserVO data) {
        return this.userDAO.insert(data);
    }

    @Override
    public void delete(UserVO data) {
        this.userDAO.delete(data);
    }

    @Override
    public void update(UserVO data) {
        this.userDAO.update(data);
    }

    @Override
    public Optional<UserVO> find(UserParam param) {
        ArrayList<UserVO> list = this.userDAO.list(param);
        if (CollectionUtils.isNotEmpty(list)){
            return Optional.of(list.get(0));
        }
        return Optional.absent();
    }

    @Override
    public ArrayList<UserVO> list(UserParam param) {
        return this.userDAO.list(param);
    }
}
