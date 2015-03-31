package com.creational.builder;

/**
 * Created by doushuqi on 15/3/25.
 */
public class TeXConverter extends TextConverter {
    private TeXText texText;

    @Override
    public void convertCharacter(char i) {
        super.convertCharacter(i);
        System.out.println("execute Plan B for Tex to convert character");
    }

    @Override
    public void convertFontChange(char i) {
        super.convertFontChange(i);
        System.out.println("execute Plan B for Tex to convert FontChange");
    }

    @Override
    public void convertParagraph() {
        super.convertParagraph();
        System.out.println("execute Plan B for Tex to convert paragraph");
    }

    public TeXText getTexText() {
        return texText;
    }
}
