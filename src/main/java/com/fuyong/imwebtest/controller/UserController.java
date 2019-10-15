package com.fuyong.imwebtest.controller;


import com.fuyong.imwebtest.configp.HelloSender;
import com.fuyong.imwebtest.pojo.User;
import com.fuyong.imwebtest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private HelloSender helloSender;
    @RequestMapping("/query")
    @ResponseBody
    public List<User> queryLimtOne() {
        List<User> lists=  userService.query();

        return userService.query();
    }



}
