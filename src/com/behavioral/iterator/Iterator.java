package com.behavioral.iterator;

/**
 * Created by doushuqi on 15/4/1.
 */
public interface Iterator {

    public Object first();
    public Object next();
    public Object currentItem();
    public boolean isHave();
}
