package com.creational.prototype;

/**
 * Created by doushuqi on 15/3/25.
 */
public class Client {
    private Prototype prototype;

    public Client(Prototype prototype) {
        this.prototype = prototype;
    }

    public Prototype operation(Prototype example) {
        Prototype copy = (Prototype) prototype.clone();
        return copy;
    }

    public static void main(String[] args) {
        Prototype prototype1 = new ConcretePrototype1();
        prototype1.setName("hello");
        Client client = new Client(prototype1);
        Prototype copy = client.operation(prototype1);
        System.out.println(copy);
    }
}
