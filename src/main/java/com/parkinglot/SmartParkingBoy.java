package com.parkinglot;

import java.util.Comparator;
import java.util.List;

import static com.parkinglot.ParkingLot.noAvailablePositionExceptionMsg;

public class SmartParkingBoy extends ParkingBoy{
    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public Ticket park(Car car) {
        List<ParkingLot> parkingLots = super.getParkingLots();

        if (parkingLots == null) {
            throw new NoAvailablePositionException(noAvailablePositionExceptionMsg);
        }

        return parkingLots.stream()
                .max(Comparator.comparing(ParkingLot::getAvailablePositionCount))
                .get()
                .park(car);
    }
}
