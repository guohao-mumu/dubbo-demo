package com.gh.dubbo.security.exception;

import org.springframework.security.core.AuthenticationException;

public class BizAuthenticationException extends AuthenticationException {
    public BizAuthenticationException(String msg, Throwable t) {
        super(msg, t);
    }

    public BizAuthenticationException(String msg) {
        super(msg);
    }
}
