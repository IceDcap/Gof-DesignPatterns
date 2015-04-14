package com.behavioral.templatemethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by doushuqi on 15/4/14.
 */
public class CoffeeWithHook extends CaffeineBeverage {
    @Override
    void brew() {
        System.out.println("Dripping Coffee through filter.");
    }

    @Override
    void addCondiments() {
        System.out.println("Adding Sugar and Milk.");
    }

    @Override
    boolean customerWantsCondiments() {
        String answer = getUserInput();
        return answer.toLowerCase().startsWith("y");
    }

    private String getUserInput() {
        String answer = null;

        System.out.println("Would you  like milk and sugar with your coffee (y/n)?");

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            answer = in.readLine();
        } catch (IOException e) {
            System.err.println("IO error trying to read your answer");
        }

        if (null == answer)
            return "no";
        return answer;
    }
}
