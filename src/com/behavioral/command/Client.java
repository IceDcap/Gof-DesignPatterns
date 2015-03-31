package com.behavioral.command;

/**
 * Created by doushuqi on 15/3/31.
 */
public class Client {
    public static void main(String[] args) {
        Light light = new Light("nb");
        RemoteControl control = new RemoteControl();
        Command on = new LightOnCommand(light);
        Command off = new LightOffCommand(light);

        control.setMenu(on);
        control.menuPressed();
        control.setMenu(off);
        control.menuPressed();
    }
}
