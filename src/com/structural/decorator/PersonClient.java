package com.structural.decorator;

/**
 * Created by shuqi on 16-9-15.
 */
public class PersonClient {

    public static void main(String[] args) {
        Person person = new Boy();
        PersonCloth expensive = new ExpensiveCloth(person);
        expensive.dress();

        new CheapCloth(person).dress();
    }
}
