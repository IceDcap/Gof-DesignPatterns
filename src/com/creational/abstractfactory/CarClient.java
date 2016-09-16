package com.creational.abstractfactory;

/**
 * Created by shuqi on 16-9-15.
 */
public class CarClient {
    public static void main(String[] args) {
        CarFactory factoryQ3 = new Q3Factory();
        factoryQ3.createTire().tire();
        factoryQ3.createEngine().engine();
        factoryQ3.createBrake().brake();
        System.out.println("---------------------");

        CarFactory factoryQ5 = new Q5Factory();
        factoryQ5.createTire().tire();
        factoryQ5.createEngine().engine();
        factoryQ5.createBrake().brake();
        System.out.println("---------------------");


        CarFactory factoryQ7 = new Q7Factory();
        factoryQ7.createTire().tire();
        factoryQ7.createEngine().engine();
        factoryQ7.createBrake().brake();
    }
}
