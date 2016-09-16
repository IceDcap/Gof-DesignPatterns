package com.creational.abstractfactory;

/**
 * ConcreteProduct
 * Created by shuqi on 16-9-15.
 */
public class DomesticEngine implements IEngine {
    @Override
    public void engine() {
        System.out.println("国产发动机");
    }
}
