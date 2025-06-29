package com.example;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class MockingTest {

    @Test
    void testMockingAList() {
        List<String> mockList = mock(List.class);
        when(mockList.get(0)).thenReturn("Hari");
        when(mockList.size()).thenReturn(1);

        String result = mockList.get(0);
        int size = mockList.size();

        assertEquals("Hari", result);
        assertEquals(1, size);

        verify(mockList).get(0);
        verify(mockList).size();
    }
}
