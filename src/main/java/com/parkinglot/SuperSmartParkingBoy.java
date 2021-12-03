package com.parkinglot;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static com.parkinglot.ParkingLot.noAvailablePositionExceptionMsg;

public class SuperSmartParkingBoy extends ParkingBoy{

    public SuperSmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public Ticket park(Car car) {
        List<ParkingLot> parkingLots = super.getParkingLots();
        return parkingLots.stream()
                .max(Comparator.comparing(parkingLot -> parkingLot.getAvailablePosition() / parkingLot.getTotalCapacity()))
                .get()
                .park(car);
    }
}
