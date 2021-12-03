package com.parkinglot;

import java.util.HashMap;

public class ParkingLot {
    private final int DEFAULT_CAPACITY = 10;
    private HashMap<Ticket, Car> ticketCarMap = new HashMap<>();
    private int capacity;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public ParkingLot() {
        this.capacity = DEFAULT_CAPACITY;
    }

    public Ticket park(Car car) {
        if (hasAvailablePosition()) {
            Ticket ticket = new Ticket();
            ticketCarMap.put(ticket, car);
            return ticket;
        }
        return null;
    }

    public Car getCar(Ticket ticket) {
        if (ticket != null) {
            if (ticket.isUsed()) {
                return null;
            }
            ticket.setUsed(true);
        }
        return ticketCarMap.get(ticket);
    }

    private boolean hasAvailablePosition() {
        return ticketCarMap.size() < capacity;
    }
}
