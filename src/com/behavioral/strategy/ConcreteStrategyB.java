package com.behavioral.strategy;

/**
 * Created by doushuqi on 15/4/13.
 */
public class ConcreteStrategyB implements Strategy {
    @Override
    public void orderAlgorithmic() {
        System.out.println("use insert sort algorithmic.");
    }
}
