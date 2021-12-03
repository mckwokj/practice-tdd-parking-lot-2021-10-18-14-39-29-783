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
        boolean hasAvailablePosition = ticketCarMap.size() < capacity;

        if (hasAvailablePosition) {
            Ticket ticket = new Ticket();
            ticketCarMap.put(ticket, car);
            return ticket;
        }

        throw new NoAvailablePositionException("No available position.");
    }

    public Car getCar(Ticket ticket) {
        Car car = ticketCarMap.remove(ticket);

        if (car != null) {
            return car;
        }

        throw new UnrecognizedParkingTicketException("Unrecognized Parking Ticket.");
    }
}
