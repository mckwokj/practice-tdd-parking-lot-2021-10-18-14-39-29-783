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
    void should_return_throw_no_available_position_exception_when_park_car_given_full_parking_lot_and_car() {
        // given
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();
        parkingLot.park(car);

        // when
        // then
        NoAvailablePositionException noAvailablePositionException = assertThrows(NoAvailablePositionException.class, () -> parkingLot.park(car));

        assertEquals("No available position.", noAvailablePositionException.getMessage());
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

    @Test
    void should_return_the_right_car_with_each_ticket_when_get_car_twice_given_a_parking_with_two_parked_cars() {
        // given
        ParkingLot parkingLot = new ParkingLot();

        Car car = new Car();
        Car car2 = new Car();

        Ticket ticket = parkingLot.park(car);
        Ticket ticket2 = parkingLot.park(car2);

        // when
        Car parkedCar = parkingLot.getCar(ticket);
        Car parkedCar2 = parkingLot.getCar(ticket2);

        // then
        assertEquals(car, parkedCar);
        assertEquals(car2, parkedCar2);
    }

    @Test
    void should_return_throw_unrecognized_parking_ticket_exception_when_get_car_given_a_parking_lot_and_a_used_parking_ticket() {
        // given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        Ticket ticket = parkingLot.park(car);
        parkingLot.getCar(ticket);

        // when
        // then
        UnrecognizedParkingTicketException unrecognizedParkingTicketException = assertThrows(UnrecognizedParkingTicketException.class, () -> parkingLot.getCar(ticket));

        assertEquals("Unrecognized Parking Ticket.", unrecognizedParkingTicketException.getMessage());
    }
}
