package com.gh.dubbo.user.service;

import com.gh.dubbo.user.dal.mapper.TUserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: guohao
 * @Date: 2019/12/11 11:26
 * @Description:
 */
@Slf4j
@Service
public class TUserService {

    @Autowired
    private TUserMapper tUserMapper;
}
