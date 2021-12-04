package com.parkinglot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
        parkingLotManager.park(firstParkingBoy, new Car()); // first parking boy

        // then
        assertEquals(9, firstParkingLot.getAvailablePosition());
        assertEquals(10, secondParkingLot.getAvailablePosition());
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
}
