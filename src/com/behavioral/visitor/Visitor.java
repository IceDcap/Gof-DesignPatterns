package com.behavioral.visitor;

/**
 * Created by doushuqi on 15/4/14.
 */
public interface Visitor {
    public void visit(GladiolusConcreteElement gladiolus);
    public void visit(ChrysanthemumConcreteElement chrysanthemum);
}
