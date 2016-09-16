package com.creational.factorymethod;

/**
 * Created by shuqi on 16-9-15.
 */
public class AudiQ3 extends AudiCar {
    @Override
    public void drive() {
        System.out.println("Q3 drive.");
    }

    @Override
    public void selfNavigation() {
        System.out.println("Q3 self navigation.");
    }
}
