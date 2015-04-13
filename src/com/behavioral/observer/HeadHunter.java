package com.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by doushuqi on 15/4/7.
 */
public class HeadHunter implements Subject {
    private List<Observer> observers;
    private List<String> jobs;

    public HeadHunter() {
        observers = new ArrayList<Observer>();
        jobs = new ArrayList<String>();
    }

    @Override
    public void attach(Observer o) {
        observers.add(o);
    }

    @Override
    public void detach(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyAllObserver() {
        for (Observer o : observers) {
            o.update(this);
        }
    }

    //add jobs info
    public void addJobs(String job) {
        jobs.add(job);
        notifyAllObserver();
    }

    public List<String> getJobs() {
        return jobs;
    }

    @Override
    public String toString() {
        return "HeadHunter{" +
                "jobs=" + jobs +
                '}';
    }
}
