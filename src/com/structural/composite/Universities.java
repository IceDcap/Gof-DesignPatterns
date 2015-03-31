package com.structural.composite;

/**
 * Component
 */
public abstract class Universities {
    private String name;

    protected Universities(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected abstract void add(Universities universities);
    protected abstract void remove(Universities universities);
    protected abstract void getChild(int depth);
}
