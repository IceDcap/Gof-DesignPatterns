package com.creational.builder;

/**
 * Created by doushuqi on 15/3/25.
 */
public class Client {
    public static void main(String[] args) {
        //initialize builder
        ASCIIConverter asciiConverter = new ASCIIConverter();

        //initialize director
        RTFReader rtfReader = new RTFReader(asciiConverter);

        //construct products
        rtfReader.parseRTF(1);
        rtfReader.parseRTF(2);

        //get product
        ASCIIText product = asciiConverter.getASCIIText();
        System.out.println(product.getName());
    }
}
