package com.gh.dubbo.commons.request;

import java.io.Serializable;

/**
 * @Auther: guohao
 * @Date: 2019/12/10 18:57
 */
public abstract class AbstractRequest implements Serializable{

    private static final long serialVersionUID = 1717442845820713651L;
    public abstract void requestCheck();

    @Override
    public String toString() {
        return "AbstractRequest{}";
    }
}
