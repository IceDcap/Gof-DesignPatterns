package com.behavioral.templatemethod;

/**
 * Created by doushuqi on 15/4/14.
 */
public class Client {
    public static void main(String[] args) {
        //Tea
        Tea tea = new Tea();
        tea.prepareRecipe();
        System.out.println("--------------------");
        //Coffee
        Coffee coffee = new Coffee();
        coffee.prepareRecipe();
        System.out.println("--------------------");
        //hook
        CoffeeWithHook hook = new CoffeeWithHook();
        hook.prepareRecipe();
    }
}
