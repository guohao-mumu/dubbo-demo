package com.gh.dubbo.security.authentication;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.PrintWriter;

@Slf4j
public class LoginHandler {

    private static JSONObject getReturn(String code, String message) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", code);
        jsonObject.put("message", message);
        return jsonObject;
    }


    public static AuthenticationSuccessHandler successHandler = (httpServletRequest, httpServletResponse, authentication) -> {
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        PrintWriter writer = httpServletResponse.getWriter();
        writer.write(getReturn("200", "欢迎登陆系统。").toJSONString());
    };
    public static AuthenticationFailureHandler failureHandler = (httpServletRequest, httpServletResponse, e) -> {
        if (log.isWarnEnabled()) {
            log.warn("errorMsg:{}", e.getMessage(), e);
        }
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        PrintWriter writer = httpServletResponse.getWriter();
        writer.write(getReturn("fail", e.getMessage()).toJSONString());
    };

}
