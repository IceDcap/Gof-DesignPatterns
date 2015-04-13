package com.behavioral.strategy;

/**
 * Created by doushuqi on 15/4/13.
 */
public class ConcreteStrategyA implements Strategy {
    @Override
    public void orderAlgorithmic() {
        System.out.println("use quick sort algorithmic.");
    }
}
