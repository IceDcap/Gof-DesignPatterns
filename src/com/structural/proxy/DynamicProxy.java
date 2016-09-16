package com.structural.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by shuqi on 16-9-15.
 */
public class DynamicProxy implements InvocationHandler {
    private Object object;//被代理的对象，具体不清楚是什么，在运行时自动获取

    public DynamicProxy(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = method.invoke(object, args);
        return result;
    }
}
