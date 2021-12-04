package com.parkinglot;

import java.util.List;

public class ParkingLotManager extends ParkingBoy{
    private List<ParkingBoy> parkingBoys;

    public ParkingLotManager(List<ParkingLot> parkingLots, List<ParkingBoy> parkingBoys) {
        super(parkingLots);
        this.parkingBoys = parkingBoys;
    }

    public Ticket park(ParkingBoy parkingBoy, Car car) {
        if (parkingBoys.contains(parkingBoy)) {
            return parkingBoy.park(car);
        }
        return null;
    }

    public Car getCar(ParkingBoy parkingBoy, Ticket ticket) {
        if (parkingBoys.contains(parkingBoy)) {
            return parkingBoy.getCar(ticket);
        }
        return null;
    }
}
