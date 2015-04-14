package com.behavioral.visitor;

/**
 * Created by doushuqi on 15/4/14.
 */
public class Client {
    public static void main(final String[] args)
    {
        final ObjectStructure os = new ObjectStructure();
        os.addElement(new GladiolusConcreteElement());
        os.addElement(new ChrysanthemumConcreteElement());

        final GladiolusVisitor gVisitor = new GladiolusVisitor();
        final ChrysanthemumVisitor chVisitor = new ChrysanthemumVisitor();

        os.accept(gVisitor);
        os.accept(chVisitor);

    }
}
