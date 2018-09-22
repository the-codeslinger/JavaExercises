package com.thecodeslinger.javaexercise.io;

import java.util.Scanner;

public class StandardIn {
	/**
	 * Ask the user to input an integer. 
	 * 
	 * <i>Note:</i> For the sake of simplicity it is assumed that the value {@code 0} means 
	 * "do nothing" or the user's input was invalid.
	 * 
	 * @return
	 * The user's input converted to an {@code int} if it was a number.
	 * 
	 * @throws NumberFormatException
	 * The user's input cannot be converted to {@code int}.
	 */
	public int readInt() {
		String input = readString();
		return Integer.parseInt(input);
	}

	/**
	 * Waits for the user to input a string. 
	 * 
	 * <i>Note:</i> Spaces are ignored and everything after the first space is not returned.
	 */
	public String readString() {
		// We don't want to close System.in which happens on Scanner#close(). Thus it's wrapped 
		// in an InputStream that doesn't do that. Alternative in a 3rd party library: 
		// http://commons.apache.org/proper/commons-io/apidocs/org/apache/commons/io/input/CloseShieldInputStream.html

		try (Scanner systemInScanner = new Scanner(new NonClosingInputStreamWrapper(System.in))) {
			return systemInScanner.next();
		}
	}
}