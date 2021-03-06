package com.creational.factorymethod;

/**
 * Created by doushuqi on 15/3/25.
 * Creator
 */
public abstract class Application {
    public MyDocumnet createDocument(){
        System.out.println("create document from Creator");
        return new MyDocumnet("sophia parent");
    }
    public void newDocument(){
        System.out.println("new document from Creator");
    }
    public void openDocument(){
        System.out.println("open document from Creator");
    }

    //使用反射智能化创建类对象
    public abstract  <T extends Document> T createDocument(Class<T> clz);
}
