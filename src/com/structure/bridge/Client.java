package com.structure.bridge;

/**
 * Created by doushuqi on 15/3/30.
 */
public class Client {
    public static void main(String[] args) {
        //casoline bus
        Bus bus = new Bus();
        Engine casoline = new CasolineEngine();
        bus.setEngine(casoline);
        bus.loadPeople();

        //diesel truck load woods
        Truck truck = new Truck();
        Engine diesel = new DieselEngine();
        truck.setEngine(diesel);
        truck.loadGoods();


    }
}
