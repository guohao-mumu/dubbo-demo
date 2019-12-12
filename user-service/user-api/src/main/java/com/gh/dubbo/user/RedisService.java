package com.gh.dubbo.user;

/**
 * @Auther: guohao
 * @Date: 2019/12/12 15:49
 * @Description:
 */
public interface RedisService {

    void set(String key, String value);

    String get(String key);
}
