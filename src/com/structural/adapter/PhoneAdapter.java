package com.structural.adapter;

/**
 * Adapter
 */
public class PhoneAdapter implements VoltageAdapter {

    private int requestVoltage;
    private int standardVoltage = 220;

    public PhoneAdapter(int requestVoltage) {
        this.requestVoltage = requestVoltage;
    }

    public void setRequestVoltage(int requestVoltage) {
        this.requestVoltage = requestVoltage;
    }

    public void setStandardVoltage(int standardVoltage) {
        this.standardVoltage = standardVoltage;
    }

    public int getRequestVoltage() {

        return requestVoltage;
    }

    public int getStandardVoltage() {
        return standardVoltage;
    }

    @Override
    public int transformVoltage() {
        System.out.println("standard voltage is " + standardVoltage + "v.");
        System.out.println("the transform voltage is " + requestVoltage + "v.");
        return requestVoltage;
    }
}
