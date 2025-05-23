package com.ingagepartners.flashcards;

/**
 * This interface defines a method for generating random numbers.
 * It is used in the Flashcards application to generate random numbers for flashcards.
 * 
 * This interface is easy to unit test, because it can be easily mocked or stubbed in unit tests.
 */
public interface RandomNumberGenerator {
    public int getRandomNumber(int min, int max);
}
