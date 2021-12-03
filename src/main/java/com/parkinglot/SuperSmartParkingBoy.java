package com.parkinglot;

import java.util.Comparator;
import java.util.List;

public class SuperSmartParkingBoy extends ParkingBoy{

    public SuperSmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public Ticket park(Car car) {
        List<ParkingLot> parkingLots = super.getParkingLots();

        return parkingLots.stream()
                .max(Comparator.comparing(parkingLot -> parkingLot.getAvailablePosition() * 1.0 / parkingLot.getTotalCapacity()))
                .get()
                .park(car);
    }
}
