package com.behavioral.observer;

/**
 * Created by doushuqi on 15/4/7.
 */
public class Client {

    public static void main(String[] args) {
        HeadHunter hunter = new HeadHunter();
        hunter.attach(new JobSeeker("Luffy"));
        hunter.attach(new JobSeeker("Nami"));
        hunter.attach(new JobSeeker("Zoro"));
        hunter.attach(new JobSeeker("Usopp"));

        hunter.addJobs("Captain");
        hunter.addJobs("Cheater");
        hunter.addJobs("Swordsman");
    }
}
