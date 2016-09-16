package com.creational.factorymethod;

/**
 * Created by shuqi on 16-9-15.
 */
public class AudiQ7 extends AudiCar {
    @Override
    public void drive() {
        System.out.println("Q7 drive.");
    }

    @Override
    public void selfNavigation() {
        System.out.println("Q7 self navigation.");
    }
}
