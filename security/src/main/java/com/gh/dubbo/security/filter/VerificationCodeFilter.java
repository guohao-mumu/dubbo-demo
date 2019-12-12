package com.gh.dubbo.security.filter;

import com.gh.dubbo.commons.response.ResponseCodeEnum;
import com.gh.dubbo.security.authentication.LoginHandler;
import com.gh.dubbo.security.exception.BizAuthenticationException;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class VerificationCodeFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain)
            throws ServletException, IOException {
        if ("/login".equals(httpServletRequest.getRequestURI())) {
            try {
                check(httpServletRequest);
            } catch (BizAuthenticationException e) {
                LoginHandler.failureHandler.onAuthenticationFailure(httpServletRequest, httpServletResponse, e);
                return;
            }
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);

    }

    private void check(HttpServletRequest httpServletRequest) {
        String captcha = httpServletRequest.getParameter("captcha");
        HttpSession session = httpServletRequest.getSession();
        String savedValue = (String) session.getAttribute("captcha");
        if (!StringUtils.isEmpty(savedValue)) {
            session.removeAttribute("captcha");
        }
        if (StringUtils.isEmpty(captcha) || !captcha.equals(savedValue)) {
            throw new BizAuthenticationException(ResponseCodeEnum.VerificationCodeError.getMessage());
        }
    }
}
