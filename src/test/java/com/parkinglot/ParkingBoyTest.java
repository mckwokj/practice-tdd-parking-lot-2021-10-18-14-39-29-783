package com.parkinglot;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ParkingBoyTest {
    @Test
    void should_return_ticket_when_park_car_given_a_standard_parking_boy_parking_lot_and_car() {
        // given
        ParkingLot parkingLot = new ParkingLot();
        List<ParkingLot> parkingLots = new ArrayList<>();

        parkingLots.add(parkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);

        // when
        Ticket ticket = parkingBoy.park(new Car());

        // then
        assertNotNull(ticket);
    }

    @Test
    void should_park_to_first_parking_lot_when_park_car_given_standard_parking_boy_manage_two_parking_lots_both_available() {
        // given
        ParkingLot firstParkingLot = new ParkingLot();
        ParkingLot secondParkingLot = new ParkingLot();

        List<ParkingLot> parkingLots = new ArrayList<>();

        parkingLots.add(firstParkingLot);
        parkingLots.add(secondParkingLot);

        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);

        // when
        Ticket ticket = parkingBoy.park(new Car());

        // then
        assertNotNull(ticket);
        assertEquals(9, firstParkingLot.getAvailablePosition());
        assertEquals(10, secondParkingLot.getAvailablePosition());
    }

    @Test
    void should_return_the_right_car_with_each_ticket_when_get_car_twice_given_a_standard_parking_boy_manage_two_lots_both_with_parked_cars_and_two_parking_tickets() {
        // given
        ParkingLot firstParkingLot = new ParkingLot();
        ParkingLot secondParkingLot = new ParkingLot();

        Car firstCar = new Car();
        Car secondCar = new Car();

        Ticket firstTicket = firstParkingLot.park(firstCar);
        Ticket secondTicket = secondParkingLot.park(secondCar);

        List<ParkingLot> parkingLots = new ArrayList<>();

        parkingLots.add(firstParkingLot);
        parkingLots.add(secondParkingLot);

        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);

        // when
        Car firstParkedCar = parkingBoy.getCar(firstTicket);
        Car secondParkedCar = parkingBoy.getCar(secondTicket);

        // then
        assertEquals(firstCar, firstParkedCar);
        assertEquals(secondCar, secondParkedCar);
    }


}