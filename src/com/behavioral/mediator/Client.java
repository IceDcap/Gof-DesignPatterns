package com.behavioral.mediator;

/**
 * Created by doushuqi on 15/4/2.
 */
public class Client {
    public static void main(String[] args) {
        ConcreteMediator mediator = new ConcreteMediator();

        Colleague owner = new OwnerColleague();
        Colleague consumer = new ConsumerColleague();

        mediator.setColleague(owner);
        String str =owner.info("I have a 80m*m house to rent out!");
        mediator.publishMessage(str, Identity.OWNER);

        mediator.publishMessage(consumer.info("looking for a room at shengli street"), Identity.CONSUMER);
    }
}
