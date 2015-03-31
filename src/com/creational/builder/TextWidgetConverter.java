package com.creational.builder;

/**
 * Created by doushuqi on 15/3/25.
 */
public class TextWidgetConverter extends TextConverter{
    private TextWidget textWidget;

    @Override
    public void convertCharacter(char i) {
        super.convertCharacter(i);
        System.out.println("execute Plan C for TextWidget to convert character");
    }

    @Override
    public void convertFontChange(char i) {
        super.convertFontChange(i);
        System.out.println("execute Plan C for TextWidget to convert FontChange");
    }

    @Override
    public void convertParagraph() {
        super.convertParagraph();
        System.out.println("execute Plan C for TextWidget to convert paragraph");
    }

    public TextWidget getTextWidget() {
        return textWidget;
    }
}
