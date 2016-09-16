package com.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shuqi on 16-9-15.
 */
public class TicketFactory {
    static Map<String, Ticket> sTicketMap = new HashMap<>();

    public static Ticket getTicket(String f, String t) {
        String key = f + " - " + t;
        if (sTicketMap.containsKey(key)) {
            System.out.println("缓存中取票 ==> " + key);
            return sTicketMap.get(key);
        } else {
            System.out.println("创建新票 ==> " + key);
            Ticket ticket = new TrainTicket(f, t);
            sTicketMap.put(key, ticket);
            return ticket;
        }
    }
}
