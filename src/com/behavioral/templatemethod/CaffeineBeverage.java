package com.behavioral.templatemethod;

/**
 * Created by doushuqi on 15/4/14.
 */
public abstract class CaffeineBeverage {

    final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        //customer decide if add condiments.
        if (customerWantsCondiments()){
            addCondiments();
        }
    }

    abstract void brew();

    abstract void addCondiments();

    void boilWater() {
        System.out.println("Boiling water...");
    }

    void pourInCup() {
        System.out.println("Pouring into cup.");
    }

    //this is a hook. subclass can override or not.
    //default true.
    boolean customerWantsCondiments() {
        return true;
    }
}
