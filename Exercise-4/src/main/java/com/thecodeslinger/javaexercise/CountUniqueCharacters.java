package com.thecodeslinger.javaexercise;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

public class CountUniqueCharacters extends AbstractExercise {

	public static void main(String[] args) {
		new CountUniqueCharacters().run();
	}

	void run() {
		try {
			out.write("Exercise 4");
			out.writeInputPrompt();
			
			String characters = in.readString();
			out.write(containsOnlyUniqueCharacters(characters));
		}
		catch (NoSuchElementException e) {
			out.writeError("No input");
		}
	}
	
	/**
	 * Searches {@code s} if it contains duplicate characters. If so, {@code false} is
	 * returned. Otherwise, if no duplicates are found, {@code true} is returned.
	 * 
	 * <i>Note:</i> This method is case sensitive.
	 */
	boolean containsOnlyUniqueCharacters(String s) {
		final Set<Character> charLookup = new HashSet<>();
		for (char c : s.toCharArray()) {
			if (charLookup.contains(c)) {
				return false;
			}
			charLookup.add(c);
		}
		return true;
	}
}
