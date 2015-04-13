package com.behavioral.observer;

/**
 * Created by doushuqi on 15/4/7.
 */
public class JobSeeker implements Observer {

    private String name;

    public JobSeeker(String name) {
        this.name = name;
    }

    @Override
    public void update(Subject subject) {
        System.out.println(name + " receive a message.");
        System.out.println(subject);
    }
}
