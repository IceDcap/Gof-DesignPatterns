package com.behavioral.chainofresponsibility;

/**
 * Created by doushuqi on 15/3/31.
 */
public class SuggestHandler extends MailHandler {
    @Override
    protected void handleRequest(String mailType) {
        if (mailType.equals("suggest"))
            System.out.println("send the suggest email to develop department.");
    }
}
