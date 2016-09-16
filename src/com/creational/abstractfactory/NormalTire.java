package com.creational.abstractfactory;

/**
 * ConcreteProduct
 * Created by shuqi on 16-9-15.
 */
public class NormalTire implements ITire{
    @Override
    public void tire() {
        System.out.println("normal tire.");
    }
}
