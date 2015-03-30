package com.structure.decorator;

/**
 * Created by doushuqi on 15/3/30.
 */
public class Client {
    public static void main(String[] args) {
        Project developer = new Developer("developerA");
        Project managerLiu = new ManagerLiu(developer);
        Project managerWang = new ManagerWang(new Developer("developerB"));
        managerLiu.doCoding();
        managerWang.doCoding();
    }
}
