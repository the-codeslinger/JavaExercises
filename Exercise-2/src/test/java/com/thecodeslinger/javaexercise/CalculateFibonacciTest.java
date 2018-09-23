package com.thecodeslinger.javaexercise;

import com.thecodeslinger.javaexercise.io.StandardIn;
import com.thecodeslinger.javaexercise.io.StandardOut;
import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.stream.IntStream;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class CalculateFibonacciTest {

    CalculateFibonacci calc;

    @Before
    public void setup() {
        StandardOut mockOut = mock(StandardOut.class);
        StandardIn mockIn = mock(StandardIn.class);

        calc = new CalculateFibonacci();
        calc.out = mockOut;
        calc.in = mockIn;
    }

    @Test
    public void testInvalidInput() {
        // Given
        when(calc.in.readInt()).thenThrow(new NumberFormatException());

        // When
        calc.run();

        // Then
        verifyTitleAndInputPrompt();
        verify(calc.out).writeError("Invalid input");
    }

    @Test
    public void testCtrlC() {
        // Given
        when(calc.in.readInt()).thenThrow(new NoSuchElementException());

        // When
        calc.run();

        // Then
        verifyTitleAndInputPrompt();
        verify(calc.out).writeError("No input");
    }

    @Test
    public void testInputZero() {
        when(calc.in.readInt()).thenReturn(0);

        // When
        calc.run();

        // Then
        verifyTitleAndInputPrompt();
        verify(calc.out, never()).write(anyInt());
    }

    @Test
    public void testInputOne() {
        when(calc.in.readInt()).thenReturn(1);

        // When
        calc.run();

        // Then
        verifyTitleAndInputPrompt();
        verify(calc.out, never()).write(anyInt());
    }

    @Test
    public void testValidNumbers() {
        IntStream.range(2, 42).forEach(number -> {
            // Given
            reset(calc.out);
            when(calc.in.readInt()).thenReturn(number);
            // Used to verify counts. It's correctness is verified separately.
            FibonacciSequencer sequencer = new FibonacciSequencer();

            // When
            calc.run();

            // Then
            // Account for the special case of the first 2 numbers in the sequence.
            verify(calc.out, times(2)).write(1);
            while (number < sequencer.nextNumber()) {
                verify(calc.out).write(sequencer.getCurrentNumber());
            }
        });
    }

    private void verifyTitleAndInputPrompt() {
        verify(calc.out).write("Exercise 2");
        verify(calc.out).writeInputPrompt();
    }
}
