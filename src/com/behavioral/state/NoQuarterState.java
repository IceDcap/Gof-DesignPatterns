package com.behavioral.state;

/**
 * Created by doushuqi on 15/4/13.
 */
public class NoQuarterState implements State {
    GumballMachine gumballMachine;

    public NoQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("You insert a quarter");
        gumballMachine.setState(gumballMachine.getHasQuarterState());
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Sorry, handle mistake");
    }

    @Override
    public void turnCrank() {
        System.out.println("Sorry, handle mistake");
    }

    @Override
    public void dispense() {
        System.out.println("Sorry, handle mistake");
    }
}
