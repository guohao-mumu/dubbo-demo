package com.gh.dubbo.user.response;

import com.gh.dubbo.commons.response.AbstractResponse;
import com.gh.dubbo.user.response.dto.UserAuthsDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Auther: guohao
 * @Date: 2019/12/11 10:47
 * @Description:
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserAuthsResponse extends AbstractResponse {

    private UserAuthsDto userAuths;


}
