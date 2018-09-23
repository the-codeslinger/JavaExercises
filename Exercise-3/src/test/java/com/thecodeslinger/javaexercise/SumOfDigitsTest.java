package com.thecodeslinger.javaexercise;

import com.thecodeslinger.javaexercise.io.StandardIn;
import com.thecodeslinger.javaexercise.io.StandardOut;
import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.stream.IntStream;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class SumOfDigitsTest {

    SumOfDigits summer;

    @Before
    public void setup() {
        StandardOut mockOut = mock(StandardOut.class);
        StandardIn mockIn = mock(StandardIn.class);

        summer = new SumOfDigits();
        summer.out = mockOut;
        summer.in = mockIn;
    }

    @Test
    public void testSplitWithNull() {
        // When
        IntStream result = summer.splitNumberToDigits(null);

        // Then
        assertEquals(0, result.count());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSplitWithNonValidNumber() {
        summer.splitNumberToDigits("12threeFour");
    }

    @Test
    public void testSplitWithValidNumbers() {
        IntStream result = summer.splitNumberToDigits("0");
        assertArrayEquals(new int[]{0}, result.toArray());

        result = summer.splitNumberToDigits("01234");
        assertArrayEquals(new int[]{0, 1, 2, 3, 4}, result.toArray());

        result = summer.splitNumberToDigits("20394234");
        assertArrayEquals(new int[]{2, 0, 3, 9, 4, 2, 3, 4}, result.toArray());
    }

    @Test
    public void testInvalidInput() {
        // Given
        when(summer.in.readString()).thenReturn("12threefour");

        // When
        summer.run();

        // Then
        verifyTitleAndInputPrompt();
        verify(summer.out).writeError("Invalid input");
    }

    @Test
    public void testCtrlC() {
        // Given
        when(summer.in.readString()).thenThrow(new NoSuchElementException());

        // When
        summer.run();

        // Then
        verifyTitleAndInputPrompt();
        verify(summer.out).writeError("No input");
    }

    @Test
    public void testZero() {
        // Given
        when(summer.in.readString()).thenReturn("0");

        // When
        summer.run();

        // Then
        verifyTitleAndInputPrompt();
        verify(summer.out).write(0);
    }

    @Test
    public void testOne() {
        // Given
        when(summer.in.readString()).thenReturn("1");

        // When
        summer.run();

        // Then
        verifyTitleAndInputPrompt();
        verify(summer.out).write(1);
    }

    @Test
    public void testOneHundred() {
        // Given
        when(summer.in.readString()).thenReturn("100");

        // When
        summer.run();

        // Then
        verifyTitleAndInputPrompt();
        verify(summer.out).write(1);
    }

    @Test
    public void testFortyTwo() {
        // Given
        when(summer.in.readString()).thenReturn("42");

        // When
        summer.run();

        // Then
        verifyTitleAndInputPrompt();
        verify(summer.out).write(6);
    }

    @Test
    public void testPiWithoutDecimal() {
        // Given
        when(summer.in.readString()).thenReturn("314159");

        // When
        summer.run();

        // Then
        verifyTitleAndInputPrompt();
        verify(summer.out).write(23);
    }

    private void verifyTitleAndInputPrompt() {
        verify(summer.out).write("Exercise 3");
        verify(summer.out).writeInputPrompt();
    }
}
