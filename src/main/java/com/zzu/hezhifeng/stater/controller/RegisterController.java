package com.zzu.hezhifeng.stater.controller;

import com.zzu.hezhifeng.common.utils.CallResult;
import com.zzu.hezhifeng.pojo.VO.UserVO;
import com.zzu.hezhifeng.service.register.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户注册与删除
 */
@RestController
@RequestMapping("/accessPlatform/v1/register/")
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @RequestMapping(method = RequestMethod.POST)
    public CallResult  register(@RequestBody UserVO userVO){
        Long insert = registerService.insert(userVO);
        return CallResult.success();
    }

    @RequestMapping(
            method = RequestMethod.DELETE,
            path = "/{id}"
    )
    public CallResult withdraw(@PathVariable Long id){
        UserVO userVO = new UserVO();
        userVO.setId(id);
        registerService.delete(userVO);
        return CallResult.success();
    }
}
