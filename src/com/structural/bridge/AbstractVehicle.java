package com.structural.bridge;

/**
 * Created by doushuqi on 15/3/30.
 */
public abstract class AbstractVehicle implements Vehicle {

    private Engine mEngine;

    public void setEngine(Engine mEngine) {
        this.mEngine = mEngine;
    }

    @Override
    public void start() {
        mEngine.fireUp();
        mEngine.start();
    }

    @Override
    public void stop() {
        mEngine.stop();
    }

    public String carInfo() {
        return mEngine.engineInfo();
    }

}
