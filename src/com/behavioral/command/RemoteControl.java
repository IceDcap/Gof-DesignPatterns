package com.behavioral.command;

/**
 * Invoker
 */
public class RemoteControl {
    private Command menu;

    public void setMenu(Command menu) {
        this.menu = menu;
    }

    public void menuPressed() {
        menu.execute();
    }
}
