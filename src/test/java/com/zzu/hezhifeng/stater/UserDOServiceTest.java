package com.zzu.hezhifeng.stater;

import com.zzu.hezhifeng.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import com.google.common.base.Optional;

public class UserDOServiceTest extends BaseTest{

    @Autowired
    private UserService userService;

    @Test
    public void testList(){
        ArrayList<UserDO> list = userService.list(new UserParam());
        for (UserDO userDO : list){
            System.out.println(userDO);
        }
    }

    @Test
    public void testInsert(){
        UserDO userDO = new UserDO();
        userDO.setCode("2");
        userDO.setGmtCreate(new Date());
        userDO.setName("ceshi");
        userDO.setPassword("123456");
        Long res = userService.insert(userDO);
        System.out.println(res);
    }
    
    @Test
    public void testUpdate(){
        Optional optional = userService.find(2L);
        System.out.println(optional.get());
    }
}
