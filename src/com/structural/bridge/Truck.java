package com.structural.bridge;

/**
 * Created by doushuqi on 15/3/30.
 */
public class Truck extends AbstractVehicle {

    public void loadGoods() {
        System.out.println("this is a " + carInfo() + " truck," + " can load woods.");
    }
}
