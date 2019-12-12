package com.gh.dubbo.security.userdetails;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
public class MyUserDetails implements UserDetails {
    private Long userId;

    private String userName;

    private String password;

    private int enable;

    private String roles;


    private List<GrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        //TODO 暂时默认返回true
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        //TODO 暂时默认返回true
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        //TODO 暂时默认返回true
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enable == 1;
    }
}