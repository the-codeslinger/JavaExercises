package com.thecodeslinger.javaexercise;

import com.thecodeslinger.javaexercise.io.StandardIn;
import com.thecodeslinger.javaexercise.io.StandardOut;
import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CountUniqueCharactersTest {

    CountUniqueCharacters counter;

    @Before
    public void setup() {
        StandardOut mockOut = mock(StandardOut.class);
        StandardIn mockIn = mock(StandardIn.class);

        counter = new CountUniqueCharacters();
        counter.out = mockOut;
        counter.in = mockIn;
    }

    @Test
    public void testContainsUnqiueNull() {
        assertFalse(counter.containsOnlyUniqueCharacters(null));
    }

    @Test
    public void testContainsUnqiueEmptyString() {
        assertFalse(counter.containsOnlyUniqueCharacters(""));
    }

    @Test
    public void testContainsUnqiueAlbert() {
        assertTrue(counter.containsOnlyUniqueCharacters("Albert"));
    }

    @Test
    public void testContainsUnqiueAnaCaseSensitivity() {
        assertTrue(counter.containsOnlyUniqueCharacters("Ana"));
    }

    @Test
    public void testContainsUnqiueAnna() {
        assertFalse(counter.containsOnlyUniqueCharacters("Anna"));
    }

    @Test
    public void testContainsUnqiueDeutschlanD() {
        assertFalse(counter.containsOnlyUniqueCharacters("DeutschlanD"));
    }

    @Test
    public void testContainsUnqiueAA() {
        assertFalse(counter.containsOnlyUniqueCharacters("AA"));
    }

    @Test
    public void testCtrlC() {
        // Given
        when(counter.in.readString()).thenThrow(new NoSuchElementException());

        // When
        counter.run();

        // Then
        verifyTitleAndInputPrompt();
        verify(counter.out).writeError("No input");
    }

    @Test
    public void testUniqueOutputAnna() {
        // Given
        when(counter.in.readString()).thenReturn("Anna");

        // When
        counter.run();

        // Then
        verifyTitleAndInputPrompt();
        verify(counter.out).write(false);
    }

    @Test
    public void testUniqueOutputAlbert() {
        // Given
        when(counter.in.readString()).thenReturn("Albert");

        // When
        counter.run();

        // Then
        verifyTitleAndInputPrompt();
        verify(counter.out).write(true);
    }

    private void verifyTitleAndInputPrompt() {
        verify(counter.out).write("Exercise 4");
        verify(counter.out).writeInputPrompt();
    }
}
