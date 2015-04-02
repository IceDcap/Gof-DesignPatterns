package com.behavioral.iterator;

import java.util.Vector;

/**
 * Created by doushuqi on 15/4/1.
 */
public class ConcreteAggregate implements Aggregate {
    private Vector vector;

    public Vector getVector() {
        return vector;
    }

    public void setVector(Vector vector) {
        this.vector = vector;
    }

    public ConcreteAggregate() {
        vector = new Vector();
        vector.add("No.1");
        vector.add("No.2");
        vector.add("No.3");
        vector.add("No.4");
        vector.add("No.5");
    }

    @Override
    public Iterator createIterator() {
        return new ConcreteIterator(vector);
    }
}
