package com.behavioral.chainofresponsibility;

/**
 * Created by doushuqi on 15/3/31.
 */
public class SpamHandler extends MailHandler {
    @Override
    protected void handleRequest(String mailType) {
        if (mailType.equals("spam"))
            System.out.println("delete the spam email.");
        else super.successor.handleRequest(mailType);
    }
}
