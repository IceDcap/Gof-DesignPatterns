package com.behavioral.memento;

/**
 * Created by doushuqi on 15/4/7.
 */
public class Memento {

    private int vitality;
    private int aggressivity;
    private int defencivity;

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
}
