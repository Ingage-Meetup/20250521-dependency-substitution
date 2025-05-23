package com.ingagepartners.flashcards;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class FlashcardsSessionTest {
    private FlashcardsSession fixture;
    @Mock
    private RandomNumberGenerator randomNumberGenerator;
    @Mock
    private UserInputReader userInputReader;

    private AutoCloseable mocks;

    @BeforeEach
    public void setUp() {
        mocks = MockitoAnnotations.openMocks(this);
        fixture = new FlashcardsSession(userInputReader, randomNumberGenerator);
    }

    @AfterEach
    public void tearDown() throws Exception {
        mocks.close();
    }

    @Test
    public void testRunSessionWithCorrectAnswers() {
        // Mock the user input and random number generation
        int numberOfCards = 1;
        int n1 = 2;
        int n2 = 3;
        int userAnswer = 6;

        // Mock the behavior of userInputReader and randomNumberGenerator
        when(userInputReader.getUserInputInt(anyString())).thenReturn(numberOfCards, userAnswer);
        when(randomNumberGenerator.getRandomNumber(anyInt(), anyInt())).thenReturn(n1, n2);

        // Call the method under test
        FlashcardsResult result = fixture.runSession();

        // Verify the results
        assertEquals(numberOfCards, result.getTotalCards());
        assertEquals(1, result.getCorrectAnswers());
        assertEquals(0, result.getIncorrectAnswers());

        verify(userInputReader).getUserInputInt("How many problems would you like to solve? ");
        verify(randomNumberGenerator, times(2)).getRandomNumber(1, 10);
        verify(userInputReader).getUserInputInt("Flashcard 1: What is " + n1 + " * " + n2 + "? ");
    }

    @Test
    public void testRunSessionWithIncorrectAnswers() {
        // Mock the user input and random number generation
        int numberOfCards = 1;
        int n1 = 2;
        int n2 = 3;
        int userAnswer = 5;

        // Mock the behavior of userInputReader and randomNumberGenerator
        when(userInputReader.getUserInputInt(anyString())).thenReturn(numberOfCards, userAnswer);
        when(randomNumberGenerator.getRandomNumber(anyInt(), anyInt())).thenReturn(n1, n2);

        // Call the method under test
        FlashcardsResult result = fixture.runSession();

        // Verify the results
        assertEquals(numberOfCards, result.getTotalCards());
        assertEquals(0, result.getCorrectAnswers());
        assertEquals(1, result.getIncorrectAnswers());

        verify(userInputReader).getUserInputInt("How many problems would you like to solve? ");
        verify(randomNumberGenerator, times(2)).getRandomNumber(1, 10);
        verify(userInputReader).getUserInputInt("Flashcard 1: What is " + n1 + " * " + n2 + "? ");
    }

    @Test
    public void testRunSessionWithMultipleCards() {
        // Mock the user input and random number generation
        int numberOfCards = 3;
        int n1 = 2;
        int n2 = 3;
        int userAnswer1 = 6;
        int userAnswer2 = 5;
        int userAnswer3 = 9;

        // Mock the behavior of userInputReader and randomNumberGenerator
        when(userInputReader.getUserInputInt(anyString())).thenReturn(numberOfCards, userAnswer1, userAnswer2,
                userAnswer3);
        when(randomNumberGenerator.getRandomNumber(anyInt(), anyInt())).thenReturn(n1, n2, n1, n2, n1, n2);

        // Call the method under test
        FlashcardsResult result = fixture.runSession();

        // Verify the results
        assertEquals(numberOfCards, result.getTotalCards());
        assertEquals(1, result.getCorrectAnswers());
        assertEquals(2, result.getIncorrectAnswers());

        verify(userInputReader).getUserInputInt("How many problems would you like to solve? ");
        verify(randomNumberGenerator, times(6)).getRandomNumber(1, 10);
    }
}
