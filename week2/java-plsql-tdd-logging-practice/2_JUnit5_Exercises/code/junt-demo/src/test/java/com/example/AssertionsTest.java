package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AssertionsTest {

    @Test
    void testEquality() {
        assertEquals(10, 5 + 5, "Sum should be 10");
    }

    @Test
    void testArrayEquality() {
        int[] expected = {1, 2, 3};
        int[] actual = {1, 2, 3};
        assertArrayEquals(expected, actual, "Arrays should be equal");
    }

    @Test
    void testTrueCondition() {
        assertTrue(7 > 5, "7 is greater than 5");
    }

    @Test
    void testFalseCondition() {
        assertFalse(3 > 5, "3 is not greater than 5");
    }

    @Test
    void testNullAndNotNull() {
        Object obj1 = null;
        Object obj2 = new Object();

        assertNull(obj1, "Should be null");
        assertNotNull(obj2, "Should not be null");
    }
}
