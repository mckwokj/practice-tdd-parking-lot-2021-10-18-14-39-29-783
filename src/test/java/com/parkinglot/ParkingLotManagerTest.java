package com.parkinglot;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

        ParkingLotManager parkingLotManager = new ParkingLotManager(parkingBoys);

        // when
        parkingLotManager.park(firstParkingBoy, new Car()); // first parking boy

        // then
        assertEquals(9, firstParkingLot.getAvailablePosition());
        assertEquals(10, secondParkingLot.getAvailablePosition());
    }
}
