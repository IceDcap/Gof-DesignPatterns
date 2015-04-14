package com.behavioral.templatemethod;

/**
 * Created by doushuqi on 15/4/14.
 */
public class Tea extends CaffeineBeverage {
    @Override
    void brew() {
        System.out.println("Steeping the tea.");
    }

    @Override
    void addCondiments() {
        System.out.println("Adding Lemon.");
    }
}
