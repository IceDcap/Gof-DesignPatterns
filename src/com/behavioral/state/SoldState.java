package com.behavioral.state;

/**
 * Created by doushuqi on 15/4/13.
 */
public class SoldState implements State {
    GumballMachine gumballMachine;

    public SoldState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("Please wait, we are already giving you a gumball");
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
        gumballMachine.releaseBall();
        if (gumballMachine.getCount() > 0)
            gumballMachine.setState(gumballMachine.getNoQuarterState());
        else {
            gumballMachine.setState(gumballMachine.getSoldOutState());
            System.out.println("Oops, out of gumballs!");
        }
    }
}
