package com.gh.dubbo.user.dal.po;

import lombok.Data;

import java.util.Date;

@Data
public class TUserAuths {
    private Long id;

    private Long userId;

    private String userName;

    private String password;

    private Integer enable;

    private String roles;

    private Date lastLoginTime;

    private Integer status;

}