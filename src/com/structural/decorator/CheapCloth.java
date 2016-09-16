package com.structural.decorator;

/**
 * Created by shuqi on 16-9-15.
 */
public class CheapCloth extends PersonCloth {
    public CheapCloth(Person mPerson) {
        super(mPerson);
    }

    private void dressShort() {
        System.out.println("穿件短裤");
    }

    @Override
    public void dress() {
        super.dress();
        dressShort();
    }
}
