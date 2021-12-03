package com.parkinglot;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SmartParkingBoy extends ParkingBoy{
    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public Ticket park(Car car) {

        List<ParkingLot> parkingLots = super.getParkingLots();

        if (parkingLots != null) {
            List<ParkingLot> availableParkingLots = parkingLots.stream().
                    filter(parkingLot -> parkingLot.getAvailablePosition() > 0)
                    .collect(Collectors.toList());

            List<Integer> parkingLotsAvailablePositions = availableParkingLots.stream()
                    .map(ParkingLot::getAvailablePosition)
                    .collect(Collectors.toList());

            int parkingLotsAvailablePositionsResult = parkingLotsAvailablePositions.stream()
                    .reduce(availableParkingLots.get(0).getAvailablePosition(), (prevAvailablePosition, availablePosition) -> prevAvailablePosition.equals(availablePosition)
                            ? availablePosition
                            : -1);

            if (parkingLotsAvailablePositionsResult != -1) {
                return availableParkingLots.get(0).park(car);
            }
        }

        return null;
    }

    public static void main(String[] args) {
        // given
        ParkingLot firstParkingLot = new ParkingLot();
        ParkingLot secondParkingLot = new ParkingLot();

        List<ParkingLot> parkingLots = Arrays.asList(firstParkingLot, secondParkingLot);

        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);

        // when
        smartParkingBoy.park(new Car());
    }
}
