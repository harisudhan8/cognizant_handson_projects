package com.example;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class AAAPatternTest {

    Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();  // setup
        System.out.println("BeforeEach: Calculator initialized");
    }

    @AfterEach
    void tearDown() {
        System.out.println("AfterEach: Test completed");
    }

    @Test
    void testAddition() {
        // Arrange (done in setUp)
        // Act
        int result = calculator.add(10, 5);
        // Assert
        assertEquals(15, result, "Addition should be correct");
    }

    @Test
    void testSubtraction() {
        int result = calculator.subtract(10, 5);
        assertEquals(5, result, "Subtraction should be correct");
    }

    @Test
    void testMultiplication() {
        int result = calculator.multiply(3, 4);
        assertEquals(12, result, "Multiplication should be correct");
    }
}
