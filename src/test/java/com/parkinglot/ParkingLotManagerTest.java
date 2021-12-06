package com.parkinglot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotManagerTest {
    @Test
    void should_assign_parking_boy_to_park_car_when_park_car_given_a_car_a_parking_lot_manager_a_management_list_with_two_parking_boys_with_one_lot() {
        // given
        ParkingLot firstParkingLot = new ParkingLot();
        ParkingLot secondParkingLot = new ParkingLot();

        List<ParkingLot> firstBoyParkingLots = Arrays.asList(firstParkingLot);
        List<ParkingLot> secondBoyParkingLots = Arrays.asList(secondParkingLot);

        ParkingBoy firstParkingBoy = new ParkingBoy(firstBoyParkingLots);
        ParkingBoy secondParkingBoy = new ParkingBoy(secondBoyParkingLots);

        List<ParkingBoy> parkingBoys = Arrays.asList(firstParkingBoy, secondParkingBoy);

        ParkingLotManager parkingLotManager = new ParkingLotManager(null, parkingBoys);

        // when
        parkingLotManager.park(firstParkingBoy, new Car());

        // then
        assertEquals(9, firstParkingLot.getAvailablePositionCount());
        assertEquals(10, secondParkingLot.getAvailablePositionCount());
    }

    @Test
    void should_return_the_right_car_with_each_ticket_when_get_car_twice_given_a_parking_lot_manager_a_management_list_with_two_parking_boys_manage_two_lots_both_with_parked_cars_and_two_parking_tickets() {
        // given
        ParkingLot firstBoyParkingLot1 = new ParkingLot();
        ParkingLot firstBoyParkingLot2 = new ParkingLot();
        ParkingLot secondBoyParkingLot1 = new ParkingLot();
        ParkingLot secondBoyParkingLot2 = new ParkingLot();

        Car firstBoyCar1 = new Car();
        Car firstBoyCar2 = new Car();
        Car secondBoyCar1 = new Car();
        Car secondBoyCar2 = new Car();

        Ticket firstBoyLot1Ticket = firstBoyParkingLot1.park(firstBoyCar1);
        firstBoyParkingLot2.park(firstBoyCar2);

        Ticket secondBoyLot1Ticket = secondBoyParkingLot1.park(secondBoyCar1);
        secondBoyParkingLot2.park(secondBoyCar2);

        List<ParkingLot> firstBoyParkingLots = Arrays.asList(firstBoyParkingLot1, firstBoyParkingLot2);
        List<ParkingLot> secondBoyParkingLots = Arrays.asList(secondBoyParkingLot1, secondBoyParkingLot2);

        ParkingBoy firstParkingBoy = new ParkingBoy(firstBoyParkingLots);
        ParkingBoy secondParkingBoy = new ParkingBoy(secondBoyParkingLots);

        List<ParkingBoy> parkingBoys = Arrays.asList(firstParkingBoy, secondParkingBoy);

        ParkingLotManager parkingLotManager = new ParkingLotManager(null, parkingBoys);

        // when
        Car firstParkedCar = parkingLotManager.getCar(firstParkingBoy, firstBoyLot1Ticket);
        Car secondParkedCar = parkingLotManager.getCar(secondParkingBoy, secondBoyLot1Ticket);

        // then
        assertEquals(firstBoyCar1, firstParkedCar);
        assertEquals(secondBoyCar1, secondParkedCar);
    }

    @Test
    void should_return_ticket_when_park_car_given_a_parking_lot_manager_parking_lot_and_car() {
        // given
        ParkingLot parkingLot = new ParkingLot();
        List<ParkingLot> parkingLots = new ArrayList<>();

        parkingLots.add(parkingLot);
        ParkingLotManager parkingLotManager = new ParkingLotManager(parkingLots, null);

        // when
        Ticket ticket = parkingLotManager.park(new Car());

        // then
        assertNotNull(ticket);
    }

    @Test
    void should_park_to_first_parking_lot_when_park_car_given_standard_manager_manages_two_parking_lots_both_available() {
        // given
        ParkingLot firstParkingLot = new ParkingLot();
        ParkingLot secondParkingLot = new ParkingLot();

        List<ParkingLot> parkingLots = new ArrayList<>();

        parkingLots.add(firstParkingLot);
        parkingLots.add(secondParkingLot);

        ParkingLotManager parkingLotManager = new ParkingLotManager(parkingLots, null);

        // when
        Ticket ticket = parkingLotManager.park(new Car());

        // then
        assertNotNull(ticket);
        assertEquals(9, firstParkingLot.getAvailablePositionCount());
        assertEquals(10, secondParkingLot.getAvailablePositionCount());
    }
    @Test
    void should_return_the_right_car_with_each_ticket_when_get_car_twice_given_a_manager_manages_two_lots_both_with_parked_cars_and_two_parking_tickets() {
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

        ParkingLotManager parkingLotManager = new ParkingLotManager(parkingLots, null);

        // when
        Car firstParkedCar = parkingLotManager.getCar(firstTicket);
        Car secondParkedCar = parkingLotManager.getCar(secondTicket);

        // then
        assertEquals(firstCar, firstParkedCar);
        assertEquals(secondCar, secondParkedCar);
    }

    @Test
    void should_throw_unrecognized_parking_ticket_exception_when_get_car_given_a_manager_a_management_list_with_two_parking_boys_with_a_lot_an_unrecognized_ticket() {
        // given
        ParkingLot firstBoyParkingLot = new ParkingLot();
        ParkingLot secondBoyParkingLot = new ParkingLot();

        firstBoyParkingLot.park(new Car());
        secondBoyParkingLot.park(new Car());

        List<ParkingLot> firstBoyParkingLots = new ArrayList<>();
        List<ParkingLot> secondBoyParkingLots = new ArrayList<>();

        firstBoyParkingLots.add(firstBoyParkingLot);
        secondBoyParkingLots.add(secondBoyParkingLot);

        ParkingBoy firstParkingBoy = new ParkingBoy(firstBoyParkingLots);
        ParkingBoy secondParkingBoy = new ParkingBoy(secondBoyParkingLots);

        List<ParkingBoy> parkingBoys = Arrays.asList(firstParkingBoy, secondParkingBoy);

        ParkingLotManager parkingLotManager = new ParkingLotManager(null, parkingBoys);

        Ticket ticket = new Ticket();

        // when
        // then
        UnrecognizedParkingTicketException unrecognizedParkingTicketException = assertThrows(UnrecognizedParkingTicketException.class,
                () -> parkingLotManager.getCar(firstParkingBoy, ticket));

        assertEquals(ParkingLotManager.unrecognizedParkingTicketExceptionMsg, unrecognizedParkingTicketException.getMessage());
    }
    @Test
    void should_throw_unrecognized_parking_ticket_exception_when_get_car_given_a_manager_a_management_list_with_two_parking_boys_with_a_lot_an_used_ticket() {
        // given
        ParkingLot firstBoyParkingLot = new ParkingLot();
        ParkingLot secondBoyParkingLot = new ParkingLot();

        Ticket ticket = firstBoyParkingLot.park(new Car());
        secondBoyParkingLot.park(new Car());

        List<ParkingLot> firstBoyParkingLots = new ArrayList<>();
        List<ParkingLot> secondBoyParkingLots = new ArrayList<>();

        firstBoyParkingLots.add(firstBoyParkingLot);
        secondBoyParkingLots.add(secondBoyParkingLot);

        ParkingBoy firstParkingBoy = new ParkingBoy(firstBoyParkingLots);
        ParkingBoy secondParkingBoy = new ParkingBoy(secondBoyParkingLots);

        List<ParkingBoy> parkingBoys = Arrays.asList(firstParkingBoy, secondParkingBoy);

        ParkingLotManager parkingLotManager = new ParkingLotManager(null, parkingBoys);

        parkingLotManager.getCar(firstParkingBoy, ticket);

        // when
        // then
        UnrecognizedParkingTicketException unrecognizedParkingTicketException = assertThrows(UnrecognizedParkingTicketException.class,
                () -> parkingLotManager.getCar(firstParkingBoy, ticket));

        assertEquals(ParkingLotManager.unrecognizedParkingTicketExceptionMsg, unrecognizedParkingTicketException.getMessage());
    }

    @Test
    void should_throw_no_available_position_exception_when_park_car_given_a_manager_a_management_list_with_two_parking_boys_manage_two_lots_without_any_position() {
        // given
        ParkingLot firstBoyParkingLot = new ParkingLot(1);
        ParkingLot secondBoyParkingLot = new ParkingLot(1);

        firstBoyParkingLot.park(new Car());
        secondBoyParkingLot.park(new Car());

        List<ParkingLot> firstBoyParkingLots = new ArrayList<>();
        List<ParkingLot> secondBoyParkingLots = new ArrayList<>();

        firstBoyParkingLots.add(firstBoyParkingLot);
        secondBoyParkingLots.add(secondBoyParkingLot);

        ParkingBoy firstParkingBoy = new ParkingBoy(firstBoyParkingLots);
        ParkingBoy secondParkingBoy = new ParkingBoy(secondBoyParkingLots);

        List<ParkingBoy> parkingBoys = Arrays.asList(firstParkingBoy, secondParkingBoy);

        ParkingLotManager parkingLotManager = new ParkingLotManager(null, parkingBoys);

        // when
        // then
        NoAvailablePositionException noAvailablePositionException = assertThrows(NoAvailablePositionException.class, () ->
                parkingLotManager.park(firstParkingBoy, new Car()));
        assertEquals(ParkingLotManager.noAvailablePositionExceptionMsg, noAvailablePositionException.getMessage());
    }
}
