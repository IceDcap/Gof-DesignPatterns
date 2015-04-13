package com.behavioral.strategy;


/**
 * Created by doushuqi on 15/4/13.
 */
public class Test {
    public static void main(String[] args) {
        Context context = new Context(new ConcreteStrategyA());
        context.algorithm();
        Context context1 = new Context(new ConcreteStrategyB());
        context1.algorithm();
        Context context2 = new Context(new ConcreteStrategyC());
        context2.algorithm();
    }
}
