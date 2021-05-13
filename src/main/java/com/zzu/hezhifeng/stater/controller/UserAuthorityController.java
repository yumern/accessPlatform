package com.zzu.hezhifeng.stater.controller;

import com.google.common.base.Optional;
import com.zzu.hezhifeng.common.utils.CallResult;
import com.zzu.hezhifeng.pojo.Param.UserParam;
import com.zzu.hezhifeng.pojo.VO.UserVO;
import com.zzu.hezhifeng.service.UserService;
import com.zzu.hezhifeng.service.register.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accessPlatform/v1/register")
public class UserAuthorityController {
    @Autowired
    private UserService userService;

    public CallResult login(@RequestBody UserParam param){
        Optional<UserVO> userVOOptional = userService.find(param);
        if (!userVOOptional.isPresent()){
            UserVO userVO = userVOOptional.get();
            return CallResult.success(userVO);
        }
        return CallResult.error("no User");
    }

}
