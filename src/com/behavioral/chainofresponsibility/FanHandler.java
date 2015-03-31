package com.behavioral.chainofresponsibility;

/**
 * Created by doushuqi on 15/3/31.
 */
public class FanHandler extends MailHandler {
    @Override
    protected void handleRequest(String mailType) {
        if (mailType.equals("fan"))
            System.out.println("send the fans email to ceo.");
        else successor.handleRequest(mailType);
    }
}
