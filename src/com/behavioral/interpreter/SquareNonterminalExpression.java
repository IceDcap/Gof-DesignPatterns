package com.behavioral.interpreter;

/**
 * Created by doushuqi on 15/4/1.
 */
public class SquareNonterminalExpression extends AbstractExpression{
    AbstractExpression expression;

    public SquareNonterminalExpression(AbstractExpression expression) {
        this.expression = expression;
    }

    @Override
    protected float interpreter(Context context) {
        return expression.interpreter(context) * expression.interpreter(context);
    }
}
