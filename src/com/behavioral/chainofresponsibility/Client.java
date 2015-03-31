package com.behavioral.chainofresponsibility;

/**
 * Created by doushuqi on 15/3/31.
 */
public class Client {
    public static void main(String[] args) {
        MailHandler spam = new SpamHandler();
        MailHandler fans = new FanHandler();
        MailHandler compliant = new ComplaintHandler();
        MailHandler suggest = new SuggestHandler();
        spam.setSuccessor(fans);
        fans.setSuccessor(compliant);
        compliant.setSuccessor(suggest);

        spam.handleRequest("fan");
//        spam.handleRequest("compliant");
        spam.handleRequest("suggest");
    }
}
