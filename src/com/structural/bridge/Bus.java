package com.structural.bridge;

/**
 * Created by doushuqi on 15/3/30.
 */
public class Bus extends AbstractVehicle {

    public void loadPeople() {
        System.out.println("this is a " + carInfo() + " bus," + " can load people.");
    }
}
