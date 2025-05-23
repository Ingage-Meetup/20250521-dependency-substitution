package com.ingagepartners.flashcards;

/**
 * This interface defines a method for reading user input.
 * It is used in the Flashcards application to read user input from the console.
 * 
 * This interface is easy to unit test, because it can be easily mocked or stubbed in unit tests.
 */
public interface UserInputReader {
    public int getUserInputInt(String prompt);
}
