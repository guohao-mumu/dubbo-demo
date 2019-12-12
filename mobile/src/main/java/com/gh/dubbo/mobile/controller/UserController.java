package com.gh.dubbo.mobile.controller;

import com.gh.dubbo.user.RedisService;
import com.gh.dubbo.user.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "mobile/user")
@RestController
@Api(tags = "UserController", description = "用户接口")
public class UserController {

    @Reference(timeout = 3000)
    private UserService userService;
    @Reference(timeout = 3000)
    private RedisService redisService;

    @ApiOperation("获取用户名")
    @GetMapping("/getUserName")
    public String getUserName(Long userId) {
        return userService.getUserName(userId);
    }


    @GetMapping("/get")
    public String getUserName(String key) {
        return redisService.get(key);
    }

    @GetMapping("/set")
    public String set(String key, String value) {
        redisService.set(key, value);
        return value;
    }

}
