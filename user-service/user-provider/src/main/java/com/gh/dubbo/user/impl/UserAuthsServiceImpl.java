package com.gh.dubbo.user.impl;

import com.gh.dubbo.commons.response.ResponseCodeEnum;
import com.gh.dubbo.user.UserAuthsService;
import com.gh.dubbo.user.converter.UserAuthsConverter;
import com.gh.dubbo.user.dal.po.TUserAuths;
import com.gh.dubbo.user.response.UserAuthsResponse;
import com.gh.dubbo.user.response.dto.UserAuthsDto;
import com.gh.dubbo.user.service.TUserAuthsService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Auther: guohao
 * @Date: 2019/12/11 11:50
 * @Description:
 */
@Slf4j
@Service
public class UserAuthsServiceImpl implements UserAuthsService {


    @Autowired
    private TUserAuthsService tUserAuthsService;

    @Autowired
    private UserAuthsConverter userAuthsConverter;

    @Override
    public UserAuthsResponse findByUserName(String userName) {
        UserAuthsResponse response = new UserAuthsResponse();
        TUserAuths userAuths = tUserAuthsService.findByUserName(userName);
        if (userAuths == null) {
            response.setCode(ResponseCodeEnum.QueryDataNotFound.getCode());
            response.setMessage(ResponseCodeEnum.QueryDataNotFound.getMessage());
            return response;
        }
        UserAuthsDto userAuthsDto = userAuthsConverter.poToDto(userAuths);
        response.setCode(ResponseCodeEnum.Success.getCode());
        response.setMessage(ResponseCodeEnum.Success.getMessage());
        response.setUserAuths(userAuthsDto);
        return response;
    }
}
