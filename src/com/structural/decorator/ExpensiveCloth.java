package com.structural.decorator;

/**
 * Created by shuqi on 16-9-15.
 */
public class ExpensiveCloth extends PersonCloth {
    public ExpensiveCloth(Person mPerson) {
        super(mPerson);
    }

    private void dressShirt(){
        System.out.println("穿件短衫");
    }

    private void dressLeather() {
        System.out.println("穿件皮衣");
    }

    private void dressJean() {
        System.out.println("穿件牛仔裤");
    }

    @Override
    public void dress() {
        super.dress();
        dressShirt();
        dressJean();
        dressLeather();
    }

}
