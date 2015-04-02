package com.behavioral.iterator;

/**
 * Created by doushuqi on 15/4/1.
 */
public class Client {
    public static void main(String[] args) {
        final Aggregate aggregate = new ConcreteAggregate();
        final Iterator iterator = aggregate.createIterator();
        System.out.println(iterator.first());
        while (iterator.isHave()) {
            System.out.println(iterator.next());
        }
    }
}
