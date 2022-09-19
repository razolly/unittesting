package com.example.unittesting.service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class ArrayListTest {

    List arr = Mockito.mock(ArrayList.class);

    @Test
    public void test_array_mocking_multipleTimes() {
        when(arr.size()).thenReturn(100).thenReturn(230).thenReturn(340);
        assertThat(arr.size()).isEqualTo(100);
        assertThat(arr.size()).isEqualTo(230);
        assertThat(arr.size()).isEqualTo(340);
    }

    @Test
    public void test_array_mocking_forSingleInt() {
        when(arr.get(0)).thenReturn("some value");
        assertThat(arr.get(0)).isEqualTo("some value");

        // This returns null because we didnt stub arr.get(1)
        assertThat(arr.get(1)).isEqualTo(null);
    }

    @Test
    public void test_array_mocking_forGenericInt() {
        when(arr.get(anyInt())).thenReturn("some value");
        assertThat(arr.get(0)).isEqualTo("some value");
        assertThat(arr.get(1)).isEqualTo("some value");
        assertThat(arr.get(100)).isEqualTo("some value");
    }

    @Test
    public void test_array_mocking_numberOfTimesCalled01() {
        arr.get(0);
        verify(arr).get(0);
    }

    @Test
    public void test_array_mocking_numberOfTimesCalled02() {
        arr.get(0);
        arr.get(1);
        arr.get(2);

        verify(arr, times(3)).get(anyInt());
        verify(arr, atLeast(1)).get(anyInt());
        verify(arr, never()).get(5);
    }

}
