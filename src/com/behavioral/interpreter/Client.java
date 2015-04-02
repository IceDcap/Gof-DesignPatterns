package com.behavioral.interpreter;

/**
 * Created by doushuqi on 15/4/1.
 */
public class Client {
    public static void main(String[] args) {
        final Context context = new Context(4.3f);
        final SquareNonterminalExpression squareValue = new SquareNonterminalExpression(new TerminalExpression(context.getR()));
        final MultiplyNonterminalExpression multiplyValue = new MultiplyNonterminalExpression(squareValue);

        System.out.println("result is " + multiplyValue.interpreter(context));
    }
}
