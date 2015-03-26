package com.create.factorymethod;

/**
 * Created by doushuqi on 15/3/25.
 * ConcreteProduct
 */
public class MyDocumnet extends Document{
    private String name;
    public MyDocumnet(String name) {
        this.name = name;
    }

    @Override
    public void open() {
        System.out.println("open my document: " + name);
    }

    @Override
    public void close() {
        System.out.println("close my document: " + name);
    }

    @Override
    public void save() {
        System.out.println("save my document: " + name);
    }

    @Override
    public void revert() {
        System.out.println("revert my document: " + name);
    }
}
