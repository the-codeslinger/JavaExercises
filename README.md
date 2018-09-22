# Java Exercises

## Content

Contains four simple Java exercises:

* Exercise 1: Ask a user to input a number and print it as often.
* Exercise 2: Ask a user to input a number and print all Fibonacci numbers that are smaller
* Exercise 3: Ask a user to input a number and print its sum of digits.
* Exercise 4: Ask a user to input a string and print whether it consists of unique characters only.

## Build

    gradlew build

This will build all exercises into JARs and copy them to `$projectRoot/build/allJars`

## Execute

    cd $projectRoot/build/allJars
    build/allJars> java -jar Exercise-[1-4].jar

All applications can be stopped with CTRL-C when asked for input.