package com.creational.factorymethod;

/**
 * Created by shuqi on 16-9-15.
 */
public class AudiQ5 extends AudiCar {
    @Override
    public void drive() {
        System.out.println("Q5 drive.");
    }

    @Override
    public void selfNavigation() {
        System.out.println("Q5 self navigation.");
    }
}
