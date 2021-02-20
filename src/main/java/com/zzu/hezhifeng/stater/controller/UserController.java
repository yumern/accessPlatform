package com.zzu.hezhifeng.stater.controller;

import com.zzu.hezhifeng.pojo.DO.User;
import com.zzu.hezhifeng.pojo.Param.UserParam;
import com.zzu.hezhifeng.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/user/")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("list")
    public ArrayList list(UserParam param){
        ArrayList<User> list = userService.list(param);
        return list;
    }
}
