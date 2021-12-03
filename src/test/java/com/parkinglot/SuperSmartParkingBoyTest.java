package com.parkinglot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SuperSmartParkingBoyTest {
    @Test
    void should_park_to_the_first_parking_lot_when_park_car_given_a_super_smart_parking_boy_managing_two_lots_with_same_available_rate_and_car() {
        // given
        ParkingLot firstParkingLot = new ParkingLot();
        ParkingLot secondParkingLot = new ParkingLot();

        List<ParkingLot> parkingLots = Arrays.asList(firstParkingLot, secondParkingLot);

        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);

        // when
        superSmartParkingBoy.park(new Car());

        // then
        assertEquals(9, firstParkingLot.getAvailablePosition());
        assertEquals(10, secondParkingLot.getAvailablePosition());
    }

    @Test
    void should_park_to_second_lot_when_park_car_given_a_super_smart_parking_boy_managing_two_lots_both_with_parked_car_and_second_have_larger_available_rate_and_car() {
        // given
        ParkingLot firstParkingLot = new ParkingLot();
        ParkingLot secondParkingLot = new ParkingLot();

        firstParkingLot.park(new Car());
        firstParkingLot.park(new Car());

        secondParkingLot.park(new Car());

        List<ParkingLot> parkingLots = Arrays.asList(firstParkingLot, secondParkingLot);

        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);

        // when
        superSmartParkingBoy.park(new Car());

        // then
        assertEquals(8, firstParkingLot.getAvailablePosition());
        assertEquals(8, secondParkingLot.getAvailablePosition());

    }

    @Test
    void should_return_the_right_car_with_each_ticket_when_get_car_twice_given_a_super_smart_parking_boy_manage_two_lots_both_with_parked_cars_and_two_parking_tickets() {
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

        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);

        // when
        Car firstParkedCar = superSmartParkingBoy.getCar(firstTicket);
        Car secondParkedCar = superSmartParkingBoy.getCar(secondTicket);

        // then
        assertEquals(firstCar, firstParkedCar);
        assertEquals(secondCar, secondParkedCar);
    }

    @Test
    void should_throw_unrecognized_parking_ticket_exception_when_get_car_given_a_super_smart_parking_boy_manage_two_lots_an_unrecognized_ticket() {
        // given
        ParkingLot firstParkingLot = new ParkingLot();
        ParkingLot secondParkingLot = new ParkingLot();

        List<ParkingLot> parkingLots = new ArrayList<>();

        parkingLots.add(firstParkingLot);
        parkingLots.add(secondParkingLot);

        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);

        Ticket ticket = new Ticket();

        // when
        // then
        UnrecognizedParkingTicketException unrecognizedParkingTicketException = assertThrows(UnrecognizedParkingTicketException.class,
                () -> superSmartParkingBoy.getCar(ticket));
        assertEquals(ParkingLot.unrecognizedParkingTicketExceptionMsg, unrecognizedParkingTicketException.getMessage());
    }

    @Test
    void should_throw_unrecognized_parking_ticket_exception_when_get_car_given_a_super_smart_parking_boy_manage_two_lots_a_used_ticket() {
        // given
        ParkingLot firstParkingLot = new ParkingLot();
        ParkingLot secondParkingLot = new ParkingLot();

        Car firstCar = new Car();
        Car secondCar = new Car();

        Ticket ticket = firstParkingLot.park(firstCar);
        secondParkingLot.park(secondCar);

        List<ParkingLot> parkingLots = new ArrayList<>();

        parkingLots.add(firstParkingLot);
        parkingLots.add(secondParkingLot);

        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);
        superSmartParkingBoy.getCar(ticket);

        // when
        // then
        UnrecognizedParkingTicketException unrecognizedParkingTicketException = assertThrows(UnrecognizedParkingTicketException.class,
                () -> superSmartParkingBoy.getCar(ticket));
        assertEquals(ParkingLot.unrecognizedParkingTicketExceptionMsg, unrecognizedParkingTicketException.getMessage());
    }

    @Test
    void should_throw_no_available_position_exception_when_park_car_given_a_super_smart_parking_boy_manage_two_lots_without_any_position() {
        // given
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(1);

        Car firstCar = new Car();
        Car secondCar = new Car();

        firstParkingLot.park(firstCar);
        secondParkingLot.park(secondCar);

        List<ParkingLot> parkingLots = new ArrayList<>();

        parkingLots.add(firstParkingLot);
        parkingLots.add(secondParkingLot);

        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);

        // when
        // then
        NoAvailablePositionException noAvailablePositionException = assertThrows(NoAvailablePositionException.class, () ->
                superSmartParkingBoy.park(new Car()));
        assertEquals(ParkingLot.noAvailablePositionExceptionMsg, noAvailablePositionException.getMessage());
    }
}
