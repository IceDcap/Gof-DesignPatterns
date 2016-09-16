package com.creational.factorymethod;

/**
 * Created by shuqi on 16-9-15.
 */
public abstract class AudiFactory {
    public abstract <A extends AudiCar> A createAudi(Class<A> clz);
}
