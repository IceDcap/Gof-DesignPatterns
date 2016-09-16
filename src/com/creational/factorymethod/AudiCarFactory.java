package com.creational.factorymethod;

/**
 * Created by shuqi on 16-9-15.
 */
public class AudiCarFactory extends AudiFactory {
    @Override
    public <A extends AudiCar> A createAudi(Class<A> clz) {
        AudiCar audiCar = null;
        try {
            audiCar  = (AudiCar) Class.forName(clz.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return (A)audiCar;
    }
}
