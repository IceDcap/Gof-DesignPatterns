package com.behavioral.visitor;

/**
 * Created by doushuqi on 15/4/14.
 */
public class ChrysanthemumConcreteElement implements FlowerElement {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
