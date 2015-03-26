package com.create.builder;

/**
 * Created by doushuqi on 15/3/25.
 */
public class ASCIIConverter extends TextConverter {
    private ASCIIText text;

    @Override
    public void convertCharacter(char i) {
        super.convertCharacter(i);
        System.out.println("execute Plan A for ASCII to convert character");
    }

    public ASCIIText getASCIIText() {
        return text;
    }
}
