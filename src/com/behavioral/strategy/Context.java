package com.behavioral.strategy;

/**
 * Created by doushuqi on 15/4/13.
 */
public class Context {
    Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void algorithm() {
        strategy.orderAlgorithmic();
    }
}
