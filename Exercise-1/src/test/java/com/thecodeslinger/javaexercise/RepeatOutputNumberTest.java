package com.thecodeslinger.javaexercise;

import com.thecodeslinger.javaexercise.io.StandardIn;
import com.thecodeslinger.javaexercise.io.StandardOut;
import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.stream.IntStream;

import static org.mockito.Mockito.*;

public class RepeatOutputNumberTest {

    RepeatOutputNumber ron;

    @Before
    public void setup() {
        StandardOut mockOut = mock(StandardOut.class);
        StandardIn mockIn = mock(StandardIn.class);

        ron = new RepeatOutputNumber();
        ron.out = mockOut;
        ron.in = mockIn;
    }

    @Test
    public void testInvalidInput() {
        // Given
        when(ron.in.readInt()).thenThrow(new NumberFormatException());

        // When
        ron.run();

        // Then
        verifyTitleAndInputPrompt();
        verify(ron.out).writeError("Invalid input");
    }

    @Test
    public void testCtrlC() {
        // Given
        when(ron.in.readInt()).thenThrow(new NoSuchElementException());

        // When
        ron.run();

        // Then
        verifyTitleAndInputPrompt();
        verify(ron.out).writeError("No input");
    }

    @Test
    public void testInputZero() {
        when(ron.in.readInt()).thenReturn(0);

        // When
        ron.run();

        // Then
        verifyTitleAndInputPrompt();
        verify(ron.out, never()).write(anyInt());
    }

    @Test
    public void testValidNumbers() {
        IntStream.range(1, 42).forEach(number -> {
            // Given
            reset(ron.out);
            when(ron.in.readInt()).thenReturn(number);

            // When
            ron.run();

            // Then
            verifyTitleAndInputPrompt();
            verify(ron.out, times(number)).write(number);
        });
    }

    private void verifyTitleAndInputPrompt() {
        verify(ron.out).write("Exercise 1");
        verify(ron.out).writeInputPrompt();
    }
}
