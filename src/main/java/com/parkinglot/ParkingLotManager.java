package com.parkinglot;

import java.util.List;

public class ParkingLotManager {
    private List<ParkingBoy> parkingBoys;

    public ParkingLotManager(List<ParkingBoy> parkingBoys) {
        this.parkingBoys = parkingBoys;
    }

    public Ticket park(ParkingBoy parkingBoy, Car car) {
        if (parkingBoys.contains(parkingBoy)) {
            return parkingBoy.park(car);
        }
        return null;
    }
}
