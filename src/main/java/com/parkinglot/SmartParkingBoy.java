package com.parkinglot;

import java.util.Comparator;
import java.util.List;

public class SmartParkingBoy extends ParkingBoy{
    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public Ticket park(Car car) {
        List<ParkingLot> parkingLots = super.getParkingLots();
        return parkingLots.stream()
                .max(Comparator.comparing(parkingLot -> parkingLot.getAvailablePosition()))
                .get()
                .park(car);
    }
}
