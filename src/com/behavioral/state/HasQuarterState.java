package com.behavioral.state;

import java.util.Random;

/**
 * Created by doushuqi on 15/4/13.
 */
public class HasQuarterState implements State {
    GumballMachine gumballMachine;

    public HasQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("You can't insert another quarter");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Quarter returned");
        gumballMachine.setState(gumballMachine.getNoQuarterState());
    }

    @Override
    public void turnCrank() {
        System.out.println("You turned the Crank..");
        int num = (int) (Math.random() * 9);
        if (num == 0) {
            System.out.println("Congratulations, you win a prize two gumballs!");
            gumballMachine.setState(gumballMachine.getWinnerState());
        } else
            gumballMachine.setState(gumballMachine.getSoldState());
    }

    @Override
    public void dispense() {
        System.out.println("Sorry, handle mistake");
    }
}
