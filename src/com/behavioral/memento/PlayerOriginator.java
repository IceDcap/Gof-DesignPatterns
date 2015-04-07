package com.behavioral.memento;


/**
 * Created by doushuqi on 15/4/7.
 */
public class PlayerOriginator {
    private int vitality;
    private int aggressivity;
    private int defencivity;

    public PlayerOriginator(int vitality, int aggressivity, int defencivity) {
        this.vitality = vitality;
        this.aggressivity = aggressivity;
        this.defencivity = defencivity;
    }

    public void setVitality(int vitality) {
        this.vitality = vitality;
    }

    public void setAggressivity(int aggressivity) {
        this.aggressivity = aggressivity;
    }

    public void setDefencivity(int defencivity) {
        this.defencivity = defencivity;
    }

    public int getVitality() {
        return vitality;
    }

    public int getAggressivity() {
        return aggressivity;
    }

    public int getDefencivity() {
        return defencivity;
    }

    public Memento createMemento() {
        final Memento memento = new Memento();
        memento.setVitality(vitality);
        memento.setAggressivity(aggressivity);
        memento.setDefencivity(defencivity);
        return memento;
    }

    public void setMemento(final Memento memento) {
        this.vitality = memento.getVitality();
        this.aggressivity = memento.getAggressivity();
        this.defencivity = memento.getDefencivity();
    }

    public void showState() {
        System.out.println("vitality: " + vitality);
        System.out.println("aggressivity: " + aggressivity);
        System.out.println("defencivity: " + defencivity);
    }
}
