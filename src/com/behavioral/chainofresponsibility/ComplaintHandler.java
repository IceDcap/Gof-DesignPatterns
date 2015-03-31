package com.behavioral.chainofresponsibility;

/**
 * Created by doushuqi on 15/3/31.
 */
public class ComplaintHandler extends MailHandler {
    @Override
    protected void handleRequest(String mailType) {
        if (mailType.equals("complaint"))
            System.out.println("send the complaint email to law department.");
        else successor.handleRequest(mailType);
    }
}
