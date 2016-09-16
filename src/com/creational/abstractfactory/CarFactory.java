package com.creational.abstractfactory;

/**
 * AbstractFactory
 * Created by shuqi on 16-9-15.
 */
public abstract class CarFactory {
    /**
     * 生成轮胎
     * @return
     */
    public abstract ITire createTire();

    /**
     * 生产发动机
     * @return
     */
    public abstract IEngine createEngine();

    /**
     * 生产制动系统
     * @return
     */
    public abstract IBrake createBrake();
}
