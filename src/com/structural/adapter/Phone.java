package com.structural.adapter;

/**
 * Adaptee
 */
public class Phone {
    private VoltageAdapter adapter;

    public VoltageAdapter getAdapter() {
        return adapter;
    }

    public void setAdapter(VoltageAdapter adapter) {
        this.adapter = adapter;
    }

    public void inputVoltage(){
        System.out.println("The phone charge voltage is " + adapter.transformVoltage() + "v.");
    }
}
