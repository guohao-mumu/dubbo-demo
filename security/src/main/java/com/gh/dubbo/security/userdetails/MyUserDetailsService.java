package com.gh.dubbo.security.userdetails;

import com.gh.dubbo.user.UserAuthsService;
import com.gh.dubbo.user.response.UserAuthsResponse;
import com.gh.dubbo.user.response.dto.UserAuthsDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class MyUserDetailsService implements UserDetailsService {

    @Reference
    private UserAuthsService userAuthsService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {


        UserAuthsResponse userAuthsResponse = userAuthsService.findByUserName(userName);
        if (!userAuthsResponse.success()) {
            if (log.isWarnEnabled()) {
                log.warn("userName: {},errorMsg :{}", userName, userAuthsResponse.getMessage());
            }
            throw new UsernameNotFoundException("用户不存在");
        }
        UserAuthsDto userAuths = userAuthsResponse.getUserAuths();
        MyUserDetails myUserDetails = new MyUserDetails();
        myUserDetails.setUserName(userAuths.getUserName());
        myUserDetails.setPassword(userAuths.getPassword());
        myUserDetails.setEnable(userAuths.getEnable());
        myUserDetails.setUserId(userAuths.getUserId());
        myUserDetails.setAuthorities(generateAuthorityList(userAuths.getRoles()));
        return myUserDetails;
    }

    private List<GrantedAuthority> generateAuthorityList(String roles) {
        List<GrantedAuthority> list = new ArrayList<>();
        if (roles != null && !"".equals(roles)) {
            String[] split = roles.split(",");
            for (String s : split) {
                list.add(new SimpleGrantedAuthority(s));
            }
        }
        return list;
    }

    public static void main(String[] args) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encode = passwordEncoder.encode("123456");
        System.out.println(encode);
    }
}
