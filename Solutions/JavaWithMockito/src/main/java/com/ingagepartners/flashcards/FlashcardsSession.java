package com.ingagepartners.flashcards;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * This is the main business logic of the Flashcards application.
 * It uses the UserInputReader to get user input and the RandomNumberGenerator to generate random numbers.
 * 
 * This class is easy to unit test, because it depends on the UserInputReader and RandomNumberGenerator interfaces,
 * which can be easily mocked or stubbed in unit tests.
 */
@Component
public class FlashcardsSession {
    private final UserInputReader userInputReader;
    private final RandomNumberGenerator randomNumberGenerator;

    public FlashcardsSession(@Autowired UserInputReader userInputReader, @Autowired RandomNumberGenerator randomNumberGenerator) {
        this.userInputReader = userInputReader;
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public FlashcardsResult runSession() {
        System.out.println("Welcome to the Flashcards Session!");

        int numberOfCards = userInputReader.getUserInputInt("How many problems would you like to solve? ");
        
        FlashcardsResult result = new FlashcardsResult(numberOfCards);
        for (int i = 0; i < numberOfCards; i++) {
            int n1 = randomNumberGenerator.getRandomNumber(1, 10);
            int n2 = randomNumberGenerator.getRandomNumber(1, 10);

            int userAnswer = userInputReader.getUserInputInt("Flashcard " + (i + 1) + ": What is " + n1 + " * " + n2 + "? ");
            if (userAnswer == n1 * n2) {
                System.out.println("Correct!");
                result.incrementCorrectAnswers();
            } else {
                System.out.println("Incorrect. The correct answer is " + (n1 * n2));
                result.incrementIncorrectAnswers();
            }
        }

        return result;
    }
}
