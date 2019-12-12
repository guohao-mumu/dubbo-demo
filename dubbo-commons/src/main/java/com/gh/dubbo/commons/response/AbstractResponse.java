package com.gh.dubbo.commons.response;

import lombok.Data;

import java.io.Serializable;


/**
 * @Auther: guohao
 * @Date: 2019/12/10 18:57
 */
@Data
public abstract class AbstractResponse implements Serializable {

    private String code;
    private String message;

    public boolean success() {
        return ResponseCodeEnum.Success.getCode().equals(code);
    }

}
