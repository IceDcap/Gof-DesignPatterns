package com.create.prototype;

/**
 * Created by doushuqi on 15/3/25.
 */
public class Client {
    private Prototype prototype;

    public Client(Prototype prototype) {
        this.prototype = prototype;
    }

    public void operation(Prototype example) {
        Prototype copy = (Prototype)prototype.clone();
    }
}
