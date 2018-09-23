package com.thecodeslinger.javaexercise;

import java.util.NoSuchElementException;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class SumOfDigits extends AbstractExercise {

    public static void main(String[] args) {
        new SumOfDigits().run();
    }

    void run() {
        try {
            out.write("Exercise 3");
            out.writeInputPrompt();

            String number = in.readString();
            IntStream digits = splitNumberToDigits(number);
            out.write(digits.sum());
        }
        catch (IllegalArgumentException e) {
            out.writeError("Invalid input");
        }
        catch (NoSuchElementException e) {
            out.writeError("No input");
        }
    }

    /**
     * Turns the {@code number} into an {@link IntStream} of its individual digits and
     * returns it.
     */
    IntStream splitNumberToDigits(String number) {
        if (null == number) {
            return IntStream.empty();
        }

        if (!Pattern.matches("[0-9]*", number)) {
            throw new IllegalArgumentException("Not a number");
        }

        return number.codePoints()
                .mapToObj(c -> String.valueOf((char)c))
                .mapToInt(Integer::parseInt);
    }
}
