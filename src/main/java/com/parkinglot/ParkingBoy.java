package com.parkinglot;

import java.util.List;
import java.util.stream.Collectors;

public class ParkingBoy {
    private List<ParkingLot> parkingLots;

    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Ticket park(Car car) {
        return parkingLots.stream()
                .filter(parkingLot -> parkingLot.getAvailablePosition() > 0)
                .findFirst()
                .get()
                .park(car);
    }

    public Car getCar(Ticket ticket) {
        return parkingLots.stream()
                .filter(parkingLot -> parkingLot.isContainCar(ticket))
                .findFirst()
                .get()
                .getCar(ticket);
    }
}
