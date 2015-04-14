package com.behavioral.templatemethod;

/**
 * Created by doushuqi on 15/4/14.
 */
public class Coffee extends CaffeineBeverage {
    @Override
    void brew() {
        System.out.println("Dripping Coffee through filter.");
    }

    @Override
    void addCondiments() {
        System.out.println("Adding Sugar and Milk.");
    }
}
