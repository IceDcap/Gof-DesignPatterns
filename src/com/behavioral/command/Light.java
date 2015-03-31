package com.behavioral.command;

/**
 * Receiver
 */
public class Light {
    private String brandName;

    public Light(String brandName) {
        this.brandName = brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void on(){
        System.out.println(brandName + " turned on...");
    }
    public void off(){
        System.out.println(brandName + " turned off...");
    }
}
