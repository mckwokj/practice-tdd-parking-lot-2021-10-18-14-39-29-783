package com.parkinglot;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SmartParkingBoyTest {
    @Test
    void should_park_to_the_first_parking_lot_when_park_car_given_a_smart_parking_boy_managing_two_lots_with_same_number_of_empty_positions() {
        // given
        ParkingLot firstParkingLot = new ParkingLot();
        ParkingLot secondParkingLot = new ParkingLot();

        List<ParkingLot> parkingLots = Arrays.asList(firstParkingLot, secondParkingLot);

        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);

        // when
        smartParkingBoy.park(new Car());

        // then
        assertEquals(9, firstParkingLot.getAvailablePosition());
        assertEquals(10, secondParkingLot.getAvailablePosition());
    }

    @Test
    void should_park_to_second_lot_when_park_car_given_a_smart_parking_boy_managing_two_lots_both_with_parked_car_and_second_have_more_positions() {
        // given
        ParkingLot firstParkingLot = new ParkingLot();
        ParkingLot secondParkingLot = new ParkingLot();

        firstParkingLot.park(new Car());
        firstParkingLot.park(new Car());

        secondParkingLot.park(new Car());

        List<ParkingLot> parkingLots = Arrays.asList(firstParkingLot, secondParkingLot);

        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);

        // when
        smartParkingBoy.park(new Car());

        // then
        assertEquals(8, firstParkingLot.getAvailablePosition());
        assertEquals(8, secondParkingLot.getAvailablePosition());

    }


}
