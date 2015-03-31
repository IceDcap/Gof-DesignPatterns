package com.structural.decorator;

/**
 * Created by doushuqi on 15/3/30.
 */
public class ManagerLiu extends Manager {
    public ManagerLiu(Project project) {
        super(project);
    }

    @Override
    public void doEarlyWork() {
        System.out.println("Manager Liu is doing requirement analysis.");
        System.out.println("Manager Liu is doing architecture design.");
        System.out.println("Manager Liu is doing detailed design.");
    }
}
