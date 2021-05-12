package com.zzu.hezhifeng.service.register.impl;

import com.google.common.base.Optional;
import com.zzu.hezhifeng.common.base.dao.AbstractDAO;
import com.zzu.hezhifeng.dao.UserDAO;
import com.zzu.hezhifeng.pojo.Param.UserParam;
import com.zzu.hezhifeng.pojo.VO.UserVO;
import com.zzu.hezhifeng.service.register.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public Long insert(UserVO data) {
        Long insert = userDAO.insert(data);
        return insert;
    }

    public Long add(UserVO userVO) {
        Long res = userDAO.insert(userVO);
        return res;
    }

    @Override
    public void delete(UserVO data) {
        userDAO.delete(data);
    }

    @Override
    public void update(UserVO data) {
        userDAO.update(data);
    }

    @Override
    public Optional<UserVO> find(UserParam param) {
        ArrayList<UserVO> list = userDAO.list(param);
        if (CollectionUtils.isEmpty(list)){
            return Optional.absent();
        }
        return Optional.of(list.get(0));
    }

    @Override
    public ArrayList<UserVO> list(UserParam param) {
        ArrayList<UserVO> list = userDAO.list(param);
        return list;
    }

}
