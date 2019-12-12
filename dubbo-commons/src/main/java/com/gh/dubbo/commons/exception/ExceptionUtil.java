
package com.gh.dubbo.commons.exception;


import com.gh.dubbo.commons.response.AbstractResponse;

public class ExceptionUtil {

    /**
     * 将下层抛出的异常转换为resp返回码
     *
     * @param e Exception
     * @return AbstractResponse
     */
    public static AbstractResponse handlerException4biz(AbstractResponse response, Exception e) throws Exception {
        if (e instanceof ValidateException) {
            response.setCode(((ValidateException) e).getErrorCode());
            response.setMessage(e.getMessage());
        } else if (e instanceof BizException) {
            response.setCode(((BizException) e).getErrorCode());
            response.setMessage(e.getMessage());
        } else if (e != null) {
            throw e; //处理不了，抛出去调用方处理
        }
        return response;
    }
}
