package com.gh.dubbo.user.response.dto;

import com.gh.dubbo.commons.AbstractObject;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @Auther: guohao
 * @Date: 2019/12/11 11:55
 * @Description:
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserAuthsDto extends AbstractObject {

    private Long userId;

    private String userName;

    private String password;

    private int enable;

    private String roles;

    private Date lastLoginTime;
}
