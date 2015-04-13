package com.behavioral.state;

/**
 * Created by doushuqi on 15/4/13.
 */
public class Test {
    public static void main(String[] args) {
        GumballMachine gumballMachine = new GumballMachine(20);
        gumballMachine.insertQuarter();
        gumballMachine.ejectQuarter();
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
    }
}
