package com.thecodeslinger.javaexercise;

import java.util.NoSuchElementException;
import java.util.stream.IntStream;

public class RepeatOutputNumber extends AbstractExercise {

	public static void main(String[] args) {
		new RepeatOutputNumber().run();
	}
	
	void run() {
		try {
			out.write("Exercise 1");
			out.writeInputPrompt();
			
			int number = in.readInt();
			IntStream.range(1, number + 1).forEach(c -> out.write(number));
		}
		catch (NumberFormatException e) {
			out.writeError("Invalid input");
		}
		catch (NoSuchElementException e) {
			out.writeError("No input");
		}
	}
}
