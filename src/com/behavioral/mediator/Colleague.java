package com.behavioral.mediator;

/**
 * Created by doushuqi on 15/4/2.
 */
public abstract class Colleague {

    protected Mediator mediator;

    public Mediator getMediator() {
        return mediator;
    }

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    protected abstract String info(String info);
}
