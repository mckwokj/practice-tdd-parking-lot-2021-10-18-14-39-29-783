package com.parkinglot;

import java.util.List;
import java.util.NoSuchElementException;

import static com.parkinglot.ParkingLot.noAvailablePositionExceptionMsg;
import static com.parkinglot.ParkingLot.unrecognizedParkingTicketExceptionMsg;

public class ParkingBoy {
    private List<ParkingLot> parkingLots;

    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public List<ParkingLot> getParkingLots() {
        return parkingLots;
    }

    public Ticket park(Car car) {
        return parkingLots.stream()
                .filter(parkingLot -> parkingLot.getAvailablePositionCount() > 0)
                .findFirst()
                .orElseThrow(() -> new NoAvailablePositionException(noAvailablePositionExceptionMsg))
                .park(car);
    }

    public Car getCar(Ticket ticket) {
        return parkingLots.stream()
                .filter(parkingLot -> parkingLot.isContainCar(ticket))
                .findFirst()
                .orElseThrow(() -> new UnrecognizedParkingTicketException(unrecognizedParkingTicketExceptionMsg))
                .getCar(ticket);
    }
}
