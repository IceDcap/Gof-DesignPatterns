package com.behavioral.interpreter;

/**
 * Created by doushuqi on 15/4/1.
 */
public class TerminalExpression extends AbstractExpression {
    private float r;

    public TerminalExpression(float r) {
        this.r = r;
    }

    @Override
    protected float interpreter(Context context) {
        return r;
    }
}
