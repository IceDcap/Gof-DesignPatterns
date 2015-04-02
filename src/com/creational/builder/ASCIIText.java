package com.creational.builder;

/**
 * Created by doushuqi on 15/3/25.
 */
public class ASCIIText {
    private String name;
    public ASCIIText(){
        System.out.println("this is product ASCII Text.");
    }

    public ASCIIText(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
