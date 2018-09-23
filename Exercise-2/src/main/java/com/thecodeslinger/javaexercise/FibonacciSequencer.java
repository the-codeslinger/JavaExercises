package com.thecodeslinger.javaexercise;

/**
 * A simple class that can compute values in a Fibonacci sequence. On first creation
 * the class is statically initialized with the first two values in the sequence.
 * 
 * @see FibonacciSequencer#getPreviousNumber()
 * @see FibonacciSequencer#getCurrentNumber()
 */
public class FibonacciSequencer {
    private int previous = 1;
    private int current = 1; 

    /**
     * Calculates the next number in the Fibonacci sequence and returns it. The 
     * internal state is updated to contain the current number as returned and the 
     * preceding two.
     * 
     * @see FibonacciSequencer#getPreviousNumber()
     * @see FibonacciSequencer#getCurrentNumber()
     */
    public int nextNumber() {
        int newCurrent = previous + current;
        previous = current;
        current = newCurrent;
        return newCurrent;
    }

    /**
     * Returns the Fibonacci number before {@link FibonacciSequencer#getCurrentNumber()}
     * (aka f-1).
     * 
     * <i>Note:</i> Right after initialization the current value is {@code 1} and
     *              represents the first number in the Fibonacci sequence.
     */
    public int getPreviousNumber() {
        return previous;
    }

    /**
     * Returns the current number in the Fibonacci sequence.
     * 
     * <i>Note:</i> Right after initialization the current value is {@code 1} and
     *              represents the second number in the Fibonacci sequence.
     */
    public int getCurrentNumber() {
        return current;
    }
}