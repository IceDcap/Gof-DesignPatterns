package com.creational.abstractfactory;

/**
 * ConcreteProduct
 * Created by shuqi on 16-9-15.
 */
public class SeniorBrake implements IBrake {
    @Override
    public void brake() {
        System.out.println("高级制动");
    }
}
