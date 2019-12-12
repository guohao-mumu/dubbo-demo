package com.gh.dubbo.user.converter;

import com.gh.dubbo.user.dal.po.TUserAuths;
import com.gh.dubbo.user.response.dto.UserAuthsDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

/**
 * @Auther: guohao
 * @Date: 2019/12/11 12:01
 * @Description:
 */
@Mapper(componentModel = "spring")
public interface UserAuthsConverter {
    @Mappings({})
    UserAuthsDto poToDto(TUserAuths userAuths);


}
