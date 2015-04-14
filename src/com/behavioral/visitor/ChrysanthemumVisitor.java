package com.behavioral.visitor;

/**
 * Created by doushuqi on 15/4/14.
 */
public class ChrysanthemumVisitor implements Visitor {
    @Override
    public void visit(GladiolusConcreteElement gladiolus) {
        System.out.println(this.getClass().getSimpleName() + " access " + gladiolus.getClass().getSimpleName());
    }

    @Override
    public void visit(ChrysanthemumConcreteElement chrysanthemum) {
        System.out.println(this.getClass().getSimpleName() + " access " + chrysanthemum.getClass().getSimpleName());
    }
}
