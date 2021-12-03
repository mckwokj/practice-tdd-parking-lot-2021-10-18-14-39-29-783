package com.parkinglot;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {
    @Test
    void should_return_ticket_when_park_car_given_parking_lot_and_car() {
        // given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();

        // when
        Ticket ticket = parkingLot.park(car);

        // then
        assertNotNull(ticket);
    }

    @Test
    void should_return_null_when_park_car_given_full_parking_lot_and_car() {
        // given
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();
        parkingLot.park(car);

        // when
        Ticket ticket = parkingLot.park(car);

        // then
        assertNull(ticket);
    }
    
    @Test
    void should_return_parked_car_when_get_car_given_parking_lot_with_the_parked_car() {
        // given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        Ticket ticket = parkingLot.park(car);

        // when
        Car parkedCar = parkingLot.getCar(ticket);

        // then
        assertEquals(car, parkedCar);
    }
    

}
