package com.behavioral.visitor;

/**
 * Created by doushuqi on 15/4/14.
 */
public interface FlowerElement {
    public void accept(Visitor visitor);
}
