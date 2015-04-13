package com.behavioral.state;

/**
 * Created by doushuqi on 15/4/13.
 */
public interface State {
    public void insertQuarter();
    public void ejectQuarter();
    public void turnCrank();
    public void dispense();
}
