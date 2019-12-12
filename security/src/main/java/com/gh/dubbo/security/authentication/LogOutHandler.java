package com.gh.dubbo.security.authentication;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import java.io.PrintWriter;

@Slf4j
public class LogOutHandler {

    private static JSONObject getReturn(String code, String message) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", code);
        jsonObject.put("message", message);
        return jsonObject;
    }


    public static LogoutSuccessHandler successHandler = (httpServletRequest, httpServletResponse, authentication) -> {
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        PrintWriter writer = httpServletResponse.getWriter();
        writer.write(getReturn("ok", "推出成功。").toJSONString());
    };


}
