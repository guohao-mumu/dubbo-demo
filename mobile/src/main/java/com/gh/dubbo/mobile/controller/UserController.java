package com.gh.dubbo.mobile.controller;

import com.gh.dubbo.user.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "mobile/user")
@RestController
public class UserController {

    @Reference(timeout = 3000)
    private UserService userService;

    @GetMapping("/getUserName")
    public String getUserName(Long userId) {
        return userService.getUserName(userId);
    }


}
