package com.structural.adapter;

/**
 * Client
 */
public class Client {
    public static void main(String[] args) {
        Phone phone = new Phone();
        VoltageAdapter adapter = new PhoneAdapter(5);
        phone.setAdapter(adapter);
        phone.inputVoltage();
    }
}
