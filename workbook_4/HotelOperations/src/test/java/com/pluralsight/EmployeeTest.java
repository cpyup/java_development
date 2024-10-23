package com.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    void punchTimeCard_PunchIn_Success(){
        // Arrange
        Employee testEmployee = new Employee("abc123","Test","Tester",15);

        // Act
        testEmployee.punchTimeCard(10.00);

        //Assert
        assertEquals(10.00,testEmployee.getStartTime());
    }

    @Test
    void punchTimeCard_PunchOut_Success(){
        // Arrange
        Employee testEmployee = new Employee("abc123","Test","Tester",15);
        testEmployee.punchTimeCard(10.00);

        // Act
        testEmployee.punchTimeCard(11.00);

        //Assert
        assertEquals(0,testEmployee.getStartTime());
        assertEquals(1,testEmployee.getHoursWorked());
    }
}