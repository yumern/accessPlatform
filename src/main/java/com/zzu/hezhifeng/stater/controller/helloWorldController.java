package com.zzu.hezhifeng.stater.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/hello")
public class helloWorldController {

    @RequestMapping(method = RequestMethod.GET)
    String sayHello(){
        return "hello world";
    };
}
