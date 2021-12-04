package com.parkinglot;

import java.util.List;

import static com.parkinglot.ParkingLot.unrecognizedParkingTicketExceptionMsg;

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
        try {
            if (parkingBoys.contains(parkingBoy)) {
                return parkingBoy.getCar(ticket);
            }
        } catch (UnrecognizedParkingTicketException unrecognizedParkingTicketException) {
            throw new UnrecognizedParkingTicketException(unrecognizedParkingTicketExceptionMsg);
        }
        return null;
    }
}
