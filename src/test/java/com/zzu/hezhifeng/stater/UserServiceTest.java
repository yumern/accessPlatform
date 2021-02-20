package com.zzu.hezhifeng.stater;

import com.zzu.hezhifeng.pojo.DO.User;
import com.zzu.hezhifeng.pojo.Param.UserParam;
import com.zzu.hezhifeng.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

public class UserServiceTest extends BaseTest{

    @Autowired
    private UserService userService;

    @Test
    public void testList(){
        ArrayList<User> list = userService.list(new UserParam());
        for (User user : list){
            System.out.println(user);
        }
    }

    @Test
    public void testInsert(){
        User user = new User();
        user.setCode("2");
        user.setGmtCreate(new Date());
        user.setName("ceshi");
        user.setPassword("123456");
        Long res = userService.insert(user);
        System.out.println(res);
    }
    
    @Test
    public void testUpdate(){
        Optional optional = userService.find(2L);
        System.out.println(optional.get());
    }
}
