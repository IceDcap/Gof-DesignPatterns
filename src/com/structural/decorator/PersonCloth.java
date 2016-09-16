package com.structural.decorator;

/**
 * Created by shuqi on 16-9-15.
 */
public class PersonCloth extends Person {
    protected Person mPerson;

    public PersonCloth(Person mPerson) {
        this.mPerson = mPerson;
    }

    @Override
    public void dress() {
        mPerson.dress();
    }
}
