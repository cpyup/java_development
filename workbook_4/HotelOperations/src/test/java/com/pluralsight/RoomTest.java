package com.pluralsight;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    @Test
    void checkIn_AvailableRoom_Success() {  // TODO: Check Raymond's, improve and expand mine
        // Arrange
        Room testRoom = new Room(1,100);

        // Act
        testRoom.checkIn();

        // Assert
        assertTrue(testRoom.isDirty());
        assertTrue(testRoom.isOccupied());
    }

    @Test
    void checkIn_DirtyRoom_Fail() {
        // Arrange
        Room testRoom = new Room(1,100);
        testRoom.checkIn();
        testRoom.checkOut();

        // Act
        testRoom.checkIn();

        // Assert
        assertTrue(testRoom.isDirty());
        assertFalse(testRoom.isOccupied());
        assertFalse(testRoom.isOccupied());
    }

    @Test
    void checkIn_OccupiedRoom_Fail() {
        // Arrange
        Room testRoom = new Room(1,100);
        testRoom.checkIn();

        // Act
        // Assert
        assertFalse(testRoom.checkIn());
    }



    @Test
    void checkOut_OccupiedRoom_Success() {
        // Arrange
        Room testRoom = new Room(1,100);
        testRoom.checkIn();

        // Act
        testRoom.checkOut();

        // Assert
        assertFalse(testRoom.isAvailable());
    }

    @Test
    void checkOut_AvailableRoom_Fail() {
        // Arrange
        Room testRoom = new Room(1,100);

        // Act
        // Assert
        assertFalse(testRoom.isDirty());
        assertFalse(testRoom.isOccupied());
        assertFalse(testRoom.checkOut());
    }

    @Test
    void cleanRoom_DirtyEmpty_Success() {
        // Arrange
        Room testRoom = new Room(1,100);
        testRoom.checkIn();
        testRoom.checkOut();

        // Act
        testRoom.cleanRoom();

        // Assert
        assertFalse(testRoom.isOccupied());
        assertFalse(testRoom.isDirty());
    }
}