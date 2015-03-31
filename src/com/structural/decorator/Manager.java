package com.structural.decorator;

/**
 * Created by doushuqi on 15/3/30.
 */
public class Manager implements Project {
    private Project mProject;

    public Manager(Project project) {
        this.mProject = project;
    }

    @Override
    public void doCoding() {
        startNewWork();
    }

    public void startNewWork(){
        doEarlyWork();
        mProject.doCoding();
        doEndWork();
    }

    public void doEarlyWork(){}
    public void doEndWork(){}
}
