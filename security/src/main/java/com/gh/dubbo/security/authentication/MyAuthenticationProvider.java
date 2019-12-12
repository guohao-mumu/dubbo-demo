package com.gh.dubbo.security.authentication;

import com.gh.dubbo.security.userdetails.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class MyAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    @Autowired
    private MyUserDetailsService myUserDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * 添加自定义身份认证检查
     *
     * @param userDetails                         用户信息
     * @param usernamePasswordAuthenticationToken 用户名密码令牌
     * @throws AuthenticationException 异常
     */
    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {

        //校验密码
        if (usernamePasswordAuthenticationToken.getCredentials() == null) {
            String message = this.messages.getMessage
                    ("AbstractUserDetailsAuthenticationProvider.BadCredentialsException", "密码不能为空");
            throw new BadCredentialsException(message);
        } else {
            String password = usernamePasswordAuthenticationToken.getCredentials().toString();
            boolean matches = passwordEncoder.matches(password, userDetails.getPassword());
            if (!matches) {
                String message = this.messages.getMessage
                        ("AbstractUserDetailsAuthenticationProvider.BadCredentialsException", "密码错误。");
                throw new BadCredentialsException(message);
            }
        }

    }

    @Override
    protected UserDetails retrieveUser(String userName, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {
        return myUserDetailsService.loadUserByUsername(userName);
    }
}
