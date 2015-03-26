package com.create.factorymethod;

/**
 * Created by doushuqi on 15/3/25.
 * Product
 */
public abstract class Document {
    public abstract void open();
    public abstract void close();
    public abstract void save();
    public abstract void revert();

}
