package com.example;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import java.util.List;

public class VerifyingInteractionTest {

    @Test
    void testMethodCallVerification() {
        List<String> mockList = mock(List.class);

        mockList.add("Hari");
        mockList.add("Sudhan");
        mockList.clear();

        verify(mockList).add("Hari");
        verify(mockList).add("Sudhan");
        verify(mockList).clear();
    }

    @Test
    void testMethodCallCount() {
        List<String> mockList = mock(List.class);

        mockList.size();
        mockList.size();
        mockList.size();

        verify(mockList, times(3)).size();
        verify(mockList, never()).clear();
    }
}
