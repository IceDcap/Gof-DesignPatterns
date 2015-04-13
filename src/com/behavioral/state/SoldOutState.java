package com.behavioral.state;

/**
 * Created by doushuqi on 15/4/13.
 */
public class SoldOutState implements State {
    GumballMachine gumballMachine;

    public SoldOutState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("out of gumballs! Please wait...");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("out of gumballs! Please wait...");
    }

    @Override
    public void turnCrank() {
        System.out.println("out of gumballs! Please wait...");
    }

    @Override
    public void dispense() {
        System.out.println("out of gumballs! Please wait...");
    }
}
