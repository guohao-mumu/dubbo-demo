package com.gh.dubbo.user.impl;

import com.gh.dubbo.user.UserService;
import org.apache.dubbo.config.annotation.Service;

@Service(cluster = "failfast")
public class UserSerivceImpl implements UserService {
    @Override
    public String getUserName(Long userId) {
        return "this is userId = " + userId + "?v=" + System.currentTimeMillis();
    }
}
