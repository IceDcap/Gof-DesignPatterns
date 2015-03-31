package com.creational.prototype;

/**
 * Created by doushuqi on 15/3/25.
 */
public class ConcretePrototype2 implements Prototype {
    private String name;
    public Prototype clone() {
        Prototype prototype = new ConcretePrototype2();
        prototype.setName(name);
        return prototype;
    }
    
    @Override
    public void setName(String str) {
        name = str;
    }

    @Override
    public String getName() {
        return name;
    }

    public String toString() {
        return "name = " + name + " in ConcretePrototype2";
    }
}
