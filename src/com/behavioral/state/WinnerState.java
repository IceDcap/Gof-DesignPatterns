package com.behavioral.state;

/**
 * Created by doushuqi on 15/4/13.
 */
public class WinnerState implements State {
    GumballMachine gumballMachine;

    public WinnerState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("Sorry, handle mistake");
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
        if (gumballMachine.getCount() > 0) {
            System.out.println("You got two gumballs.");
            gumballMachine.setState(gumballMachine.getNoQuarterState());
        }
        else {
            gumballMachine.setState(gumballMachine.getSoldOutState());
            System.out.println("Oops, out of gumballs!");
        }
    }
}
