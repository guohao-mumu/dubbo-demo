package com.gh.dubbo.user.dal.mapper;

import com.gh.dubbo.commons.mapper.BaseMapper;
import com.gh.dubbo.user.dal.po.TUserAuths;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TUserAuthsMapper extends BaseMapper<TUserAuths> {

    TUserAuths selectByUserName(@Param("userName") String userName);
}