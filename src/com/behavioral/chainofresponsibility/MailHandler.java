package com.behavioral.chainofresponsibility;

/**
 * Created by doushuqi on 15/3/31.
 */
public abstract class MailHandler {
    protected MailHandler successor;

    public void setSuccessor(MailHandler successor) {
        this.successor = successor;
    }

    protected abstract void handleRequest(String mailType);
}
