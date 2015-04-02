package com.behavioral.interpreter;

/**
 * Created by doushuqi on 15/4/1.
 */
public class MultiplyNonterminalExpression extends AbstractExpression {
    AbstractExpression expression;

    public MultiplyNonterminalExpression(AbstractExpression expression) {
        this.expression = expression;
    }

    @Override
    protected float interpreter(Context context) {
        return Context.PI * expression.interpreter(context);
    }
}
