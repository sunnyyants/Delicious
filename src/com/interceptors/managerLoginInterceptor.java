package com.interceptors;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import java.util.Map;

/**
 * Created by Sunny on 4/16/14.
 */
public class managerLoginInterceptor extends AbstractInterceptor {
    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        ActionContext actionContext = actionInvocation.getInvocationContext();
        Map session = actionContext.getSession();

        if(session != null && session.get("managerId")!= null){
            return actionInvocation.invoke();
        }

        return "MANAGERNEEDTOLOGIN";
    }
}
