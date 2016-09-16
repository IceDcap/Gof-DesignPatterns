package com.structural.proxy;

import java.lang.reflect.Proxy;

/**
 * Created by shuqi on 16-9-15.
 */
public class Client {

    public static void main(String[] args) {
        ILawsuit yuangao = new YuanGao();
        Lawyer lawyer = new Lawyer(yuangao);
        lawyer.submit();
        lawyer.burden();
        lawyer.defend();
        lawyer.finish();

        ////动态代理
        System.out.println("---------dynamic proxy--------");
        DynamicProxy proxy = new DynamicProxy(yuangao);
        ClassLoader classLoader = yuangao.getClass().getClassLoader();
        ILawsuit lawyer2 = (ILawsuit) Proxy.newProxyInstance(classLoader, new Class[]{ILawsuit.class}, proxy);
        lawyer2.submit();
        lawyer2.burden();
        lawyer2.defend();
        lawyer2.finish();
    }
}
