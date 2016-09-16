package com.structural.flyweight;

/**
 * Created by shuqi on 16-9-15.
 */
public class Client {

    public static void main(String[] args) {
        Ticket ticket1 = TicketFactory.getTicket("北京", "上海");
        ticket1.showTicketInfo("上铺");

        Ticket ticket2 = TicketFactory.getTicket("北京", "天津");
        ticket2.showTicketInfo("上铺");

        Ticket ticket3 = TicketFactory.getTicket("北京", "上海");
        ticket3.showTicketInfo("下铺");
    }
}
