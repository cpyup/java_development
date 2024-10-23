package com.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    void punchTimeCard_validTimeCalculation_success(){
        // Arrange
        Employee testEmployee = new Employee("abc123","Test","Tester",15);
        testEmployee.punchTimeCard(10.00);

        // Act
        testEmployee.punchTimeCard(11.00);

        // Assert
        assertEquals(1.0,testEmployee.getHoursWorked());
    }
}