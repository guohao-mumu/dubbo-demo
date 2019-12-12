package com.gh.dubbo.user.impl;

import com.gh.dubbo.redis.RedisUtil;
import com.gh.dubbo.user.RedisService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Auther: guohao
 * @Date: 2019/12/12 15:50
 * @Description:
 */
@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public void set(String key, String value) {
        redisUtil.set(key, value);
    }

    @Override
    public String get(String key) {
        Object o = redisUtil.get(key);
        System.out.println(o);
        return (String) redisUtil.get(key);
    }
}
