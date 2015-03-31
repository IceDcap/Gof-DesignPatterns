package com.creational.abstractfactory;

/**
 * Created by doushuqi on 15/3/25.
 */
public class Client {
    public static void main(String[] args) {
        ConcreteFactory1 factory1 = new ConcreteFactory1();
        factory1.createProductA();
        factory1.createProductB();
        ConcreteFactory2 factory2 = new ConcreteFactory2();
        factory2.createProductA();
        factory2.createProductB();
    }
}
