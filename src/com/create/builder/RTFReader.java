package com.create.builder;

/**
 * Created by doushuqi on 15/3/25.
 */
public class RTFReader {
    private TextConverter textConverter;

    public RTFReader(TextConverter textConverter) {
        this.textConverter = textConverter;
    }

    public void parseRTF(int i) {
        if (i == 1) {
            textConverter.convertCharacter('i');
        } else if (i == 2) {
            textConverter.convertFontChange('f');
        } else {
            textConverter.convertParagraph();
        }
    }
}
