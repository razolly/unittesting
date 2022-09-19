package com.example.unittesting.service;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
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

    /**
     * Verify number of times a function was called on a mock
     */
    @Test
    public void test_array_mocking_numberOfTimesCalled02() {
        arr.get(0);
        arr.get(1);
        arr.get(2);

        verify(arr, times(3)).get(anyInt());
        verify(arr, atLeast(1)).get(anyInt());
        verify(arr, never()).get(5);
    }

    /**
     * Captures arguments for functions called on a mock
     * Simple scenario
     */
    @Test
    public void argumentCaptor_simple() {
        String valueToCapture = "Value to capture";
        arr.add(valueToCapture);

        // Verification
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(arr).add(captor.capture());
        assertThat(captor.getValue()).isEqualTo(valueToCapture);
    }

    /**
     * Capture multiple arguments. Need to mention number of times its called
     */
    @Test
    public void argumentCaptor_multipleArgs() {
        arr.add("value0");
        arr.add("value1");
        arr.add("value2");

        // Verification
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        // Important to state number of times so that can capture properly
        verify(arr, times(3)).add(captor.capture());
        assertThat(captor.getAllValues().get(0)).isEqualTo("value0");
        assertThat(captor.getAllValues().get(1)).isEqualTo("value1");
        assertThat(captor.getAllValues().get(2)).isEqualTo("value2");
    }

    /**
     * Spy. Similar to mock, but retains actual behavior and allows mocking
     *
     * When to use?
     *      - When you need the real behavior of a class
     *      - When you want to observe whats happening in the class (using verify())
     *
     * Mock vs Spy
     *      https://stackoverflow.com/a/39197040
     *      https://stackoverflow.com/a/23913166
     */
    @Test
    public void spying_simple() {
        ArrayList<String> listMock = mock(ArrayList.class); // Mock
        listMock.get(0); // Will return 0, since its a stub

        ArrayList<String> listSpy = spy(ArrayList.class); // Spy
        // listSpy.get(0); // Will throw error since no elements (like a real array list)

        // Use actual arraylist behavior
        listSpy.add("1");
        listSpy.add("1");
        listSpy.add("1");
        assertThat(listSpy.size()).isEqualTo(3); // Array really has 3 objects
        verify(listSpy, times(3)).add("1");

        // Mock behavior on spy. Original behavior will be lost
        when(listSpy.size()).thenReturn(100); // Stub. Real behavior not used any more
        listSpy.add("1");
        listSpy.add("123");
        listSpy.add("123");
        assertThat(listSpy.size()).isEqualTo(100);

        // Verify behavior in class
        verify(listSpy, times(2)).add("123");
    }

}
