package com.thecodeslinger.javaexercise;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FibonacciSequencerTest {
    @Test
    public void verifySequence() {
        // Given
        FibonacciSequencer sequencer = new FibonacciSequencer();
        int f1 = 1;
        int f2 = 1;

        // Expect
        assertEquals(f1, sequencer.getCurrentNumber());
        assertEquals(f2, sequencer.getPreviousNumber());

        // Assume that when the first 100 calculations are correct that the next 100 are too.
        for (int c = 0; c < 100; c++) {
            int fn = f1 + f2;

            assertEquals(fn, sequencer.nextNumber());
            assertEquals(fn, sequencer.getCurrentNumber());
            assertEquals(f1, sequencer.getPreviousNumber());

            f2 = f1;
            f1 = fn;
        }
    }
}
