package com.behavioral.mediator;

/**
 * Created by doushuqi on 15/4/2.
 */
public class ConcreteMediator implements Mediator {
    protected Colleague colleague;

    public Colleague getColleague() {
        return colleague;
    }

    public void setColleague(Colleague colleague) {
        this.colleague = colleague;
    }

    @Override
    public void publishMessage(String str, Identity identity) {
        if (identity.equals(Identity.CONSUMER))
            System.out.println("Consumer look for a house, the detailed message is " + str + " .");
        else
        System.out.println("A house need to rent out now, the info is " + colleague.info(str));
    }
}
