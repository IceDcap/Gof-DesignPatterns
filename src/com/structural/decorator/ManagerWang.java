package com.structural.decorator;

/**
 * Created by doushuqi on 15/3/30.
 */
public class ManagerWang extends Manager {
    public ManagerWang(Project project) {
        super(project);
    }

    @Override
    public void doEarlyWork() {
        System.out.println("Manager Wang is doing requirement analysis.");
    }

    @Override
    public void doEndWork() {
        System.out.println("Manager Wang is doing ending.");
    }
}
