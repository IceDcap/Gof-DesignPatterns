package com.behavioral.observer;

/**
 * Created by doushuqi on 15/4/7.
 */
public interface Subject {
    public void attach(Observer o);
    public void detach(Observer o);
    public void notifyAllObserver();
}
