package com.behavioral.memento;

/**
 * Created by doushuqi on 15/4/7.
 */
public class Client {
    public static void main(String[] args) {
        final PlayerOriginator player = new PlayerOriginator(100, 100, 100);
        System.out.println("player's original data is ");
        player.showState();

        final CareTaker taker = new CareTaker();
        taker.setMemento(player.createMemento());//save state

        //battled
        player.setVitality(70);
        player.setAggressivity(60);
        player.setDefencivity(10);

        System.out.println("After battled with Boss, player's data is ");
        player.showState();

        //reset original data
        player.setMemento(taker.getMemento());
        System.out.println("reset data, player's data is ");
        player.showState();
    }
}
