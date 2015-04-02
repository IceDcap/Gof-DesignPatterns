package com.behavioral.iterator;

import java.util.Vector;

/**
 * Created by doushuqi on 15/4/1.
 */
public class ConcreteIterator implements Iterator {
    private int currentIndex = 0;
    private Vector vector = null;

    public ConcreteIterator(final Vector vector) {
        this.vector = vector;
    }

    @Override
    public Object first() {
        currentIndex = 0;
        return vector.get(currentIndex);
    }

    @Override
    public Object next() {
        currentIndex++;
        return vector.get(currentIndex);
    }

    @Override
    public Object currentItem() {
        return vector.get(currentIndex);
    }

    @Override
    public boolean isHave() {
        return !(currentIndex >= vector.size() - 1);

    }
}
