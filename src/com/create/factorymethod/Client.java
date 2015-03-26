package com.create.factorymethod;

/**
 * Created by doushuqi on 15/3/25.
 */
public class Client {

    public static void main(String[] args) {
        MyApplication myApplication = new MyApplication();
        MyDocumnet myDocumnet = myApplication.createDocument();
        myDocumnet.open();
        myDocumnet.revert();
        myDocumnet.save();
        myDocumnet.close();
    }
}
