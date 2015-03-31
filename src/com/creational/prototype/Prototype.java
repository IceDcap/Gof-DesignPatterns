package com.creational.prototype;

/**
 * Created by doushuqi on 15/3/25.
 */
public interface Prototype {
    public Object clone();
    public void setName(String str);
    public String getName();
}
