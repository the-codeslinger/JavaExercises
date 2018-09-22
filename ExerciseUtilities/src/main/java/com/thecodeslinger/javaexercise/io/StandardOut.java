package com.thecodeslinger.javaexercise.io;

/**
 * Contains a few convenience methods that help to write to {@link System#out} in the proper 
 * format of the exercises. Manages its own line numbering.
 */
public class StandardOut {
	/**
	 * The types of line endings supported by the 
	 * {@link RepeatOutputNumber#writeMessage(String, String, int, LineEnding)} method. 
	 */
	private static enum LineEnding {
		NewLine,
		NoNewLine
	}
	
	private int lineNumber = 1;
	
	/**
	 * Writes the given {@link text} to {@link System.out}. Adds line number at the front
	 * and a new line at the end.
	 */
	public void write(String text) {
		writeMessage(text, "-", lineNumber++, LineEnding.NewLine);
	}

	/**
	 * Writes the given {@link number} to {@link System.out}. Adds line number at the front
	 * and a new line at the end.
	 */
	public void write(int number) {
		writeMessage(Integer.toString(number), "-", lineNumber++, LineEnding.NewLine);
	}

	/**
	 * Writes the given {@link bool} to {@link System.out}. Adds line number at the front
	 * and a new line at the end.
	 */
	public void write(boolean bool) {
		writeMessage(Boolean.toString(bool), "-", lineNumber++, LineEnding.NewLine);
	}
	
	/**
	 * Writes an input prompt ">". Adds line number at the front but no new line at the end.
	 */
	public void writeInputPrompt() {
		writeMessage("", ">", lineNumber++, LineEnding.NoNewLine);
	}
	
	/**
	 * Advance to the next line, e.g. after reading user input and before writing the
	 * output.
	 */
	public void writeNewLine() {
		System.out.println();
	}
	
	/**
	 * Write an error message {@code text} to {@link System#err}. Adds a new line at the end.
	 */
	public void writeError(String text) {
		System.err.println(String.format("ERROR: %s", text));
	}
	
	/**
	 * Writes a message to {@code System.out}. Prepends the {@code lineNumber} and appends
	 * a new-line character if required.
	 */
	private static void writeMessage(String text, String separator, int lineNumber, LineEnding ending) {
		String output = String.format("%d %s %s", lineNumber, separator, text);
		if (LineEnding.NewLine == ending) {
			output = output + System.lineSeparator();
		}
		System.out.print(output);
	}
}
