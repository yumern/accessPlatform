package com.zzu.hezhifeng.service.impl;

import com.zzu.hezhifeng.dao.UserDAO;
import com.zzu.hezhifeng.pojo.DO.User;
import com.zzu.hezhifeng.pojo.Param.UserParam;
import com.zzu.hezhifeng.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService<User> {
    @Autowired
    private UserDAO userDAO;

    @Override
    public ArrayList<User> list(UserParam user) {
        ArrayList<User> list = userDAO.list(user);
        return list;
    }

    @Override
    public void update(User user) {
        userDAO.update(user);
    }

    @Override
    public Optional<User> find(Long id) {
        Assert.notNull(id, "id is null");
        UserParam user = new UserParam();
        user.setId(id);
        ArrayList<User> list = userDAO.list(user);
        if (list.isEmpty()){
            return null;
        }
        Optional<User> result = Optional.of(list.get(0));
        return result;
    }

    @Override
    public Long insert(User user) {
        Long res = userDAO.insert(user);
        return res;
    }

    @Override
    public void delete(User user) {
        userDAO.delete(user);
    }
}
