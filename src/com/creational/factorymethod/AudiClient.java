package com.creational.factorymethod;

/**
 * Created by shuqi on 16-9-15.
 */
public class AudiClient {
    public static void main(String[] args) {
        AudiFactory factory = new AudiCarFactory();
        AudiQ3 q3 = factory.createAudi(AudiQ3.class);
        q3.drive();
        q3.selfNavigation();

        AudiQ5 q5 = factory.createAudi(AudiQ5.class);
        q5.drive();
        q5.selfNavigation();

        AudiQ7 q7 = factory.createAudi(AudiQ7.class);
        q7.drive();
        q7.selfNavigation();

    }
}
