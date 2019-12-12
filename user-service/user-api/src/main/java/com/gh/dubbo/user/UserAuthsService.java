package com.gh.dubbo.user;

import com.gh.dubbo.user.response.UserAuthsResponse;

public interface UserAuthsService {

    UserAuthsResponse findByUserName(String userName);
}
