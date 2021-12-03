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
        try {
            return parkingLots.stream()
                    .filter(parkingLot -> parkingLot.getAvailablePosition() > 0)
                    .findFirst()
                    .get()
                    .park(car);
        } catch (NoSuchElementException exception) {
            throw new NoAvailablePositionException(noAvailablePositionExceptionMsg);
        }
    }

    public Car getCar(Ticket ticket) {
        try {
            return parkingLots.stream()
                    .filter(parkingLot -> parkingLot.isContainCar(ticket))
                    .findFirst()
                    .get()
                    .getCar(ticket);
        } catch (NoSuchElementException exception) {
            throw new UnrecognizedParkingTicketException(unrecognizedParkingTicketExceptionMsg);
        }
    }
}
