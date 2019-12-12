package com.gh.dubbo.commons.response;

/**
 * @Auther: guohao
 * @Date: 2019/12/11 10:52
 * @Description: 返回码枚举
 */
public enum ResponseCodeEnum {

    Success("200", "成功"),
    Error("400", "失败"),

    QueryDataNotFound("100100", "查询资源不存在"),

    VerificationCodeError("100200", "验证码错误"),

    ;


    private String code;

    private String message;

    ResponseCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }}
