package com.structure.decorator;

/**
 * Created by doushuqi on 15/3/30.
 */
public class Developer implements Project {
    private String name;

    public Developer(String name) {
        this.name = name;
    }

    @Override
    public void doCoding() {
        System.out.println(name + " is trying hard in coding...");
        System.out.println("finish coding！！");
    }
}
