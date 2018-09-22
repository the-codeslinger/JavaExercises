package com.thecodeslinger.javaexercise;

import java.util.NoSuchElementException;

public class CalculateFibonacci extends AbstractExercise {

	public static void main(String[] args) {
		new CalculateFibonacci().run();
	}
	
	void run() {
		try {
			out.write("Exercise 2");
			out.writeInputPrompt();
			
			int userInputNumber = in.readInt();
			FibonacciSequencer sequencer = new FibonacciSequencer();

			// Special case handling for the first two Fibonacci numbers.
			if (sequencer.getCurrentNumber() < userInputNumber) {
				out.write(sequencer.getPreviousNumber());
				out.write(sequencer.getCurrentNumber());
			}

			while (sequencer.nextNumber() < userInputNumber) {
				out.write(sequencer.getCurrentNumber());
			}
		}
		catch (NumberFormatException e) {
			out.writeError("Invalid input");
		}
		catch (NoSuchElementException e) {
			out.writeError("No input");
		}
	}
}
