package com.pluralsight;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    @Test
    void checkIn_availableRoom_success() {
        // Arrange
        Room testRoom = new Room(1,100);

        // Act
        testRoom.checkIn();

        // Assert
        assertFalse(testRoom.isAvailable());
    }

    @Test
    void checkIn_dirtyRoom_fail() {
        // Arrange
        Room testRoom = new Room(1,100);
        testRoom.checkIn();
        testRoom.checkOut();

        // Act
        testRoom.checkIn();

        // Assert
        assertFalse(testRoom.isOccupied());
    }

    @Test
    void checkIn_occupiedRoom_fail() {
        // Arrange
        Room testRoom = new Room(1,100);
        testRoom.checkIn();

        // Act
        // Assert
        assertFalse(testRoom.checkIn());
    }



    @Test
    void checkOut_occupiedRoom_success() {
        // Arrange
        Room testRoom = new Room(1,100);
        testRoom.checkIn();

        // Act
        testRoom.checkOut();

        // Assert
        assertFalse(testRoom.isAvailable());
    }

    @Test
    void checkOut_availableRoom_fail() {
        // Arrange
        Room testRoom = new Room(1,100);

        // Act
        // Assert
        assertFalse(testRoom.checkOut());
    }

    @Test
    void cleanRoom_dirtyEmpty_success() {
        // Arrange
        Room testRoom = new Room(1,100);
        testRoom.checkIn();
        testRoom.checkOut();

        // Act
        testRoom.cleanRoom();

        // Assert
        assertTrue(testRoom.isAvailable());
    }
}