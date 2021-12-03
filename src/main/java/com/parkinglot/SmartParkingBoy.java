package com.parkinglot;

import java.util.List;
import java.util.NoSuchElementException;

import static com.parkinglot.ParkingLot.noAvailablePositionExceptionMsg;

public class SmartParkingBoy {
    private List<ParkingLot> parkingLots;

    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Ticket park(Car car) {
        return null;
    }
}
