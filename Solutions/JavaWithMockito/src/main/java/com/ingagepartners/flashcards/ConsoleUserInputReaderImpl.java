package com.ingagepartners.flashcards;

import java.util.Scanner;

import org.springframework.stereotype.Component;

/**
 * This class implements the UserInputReader interface to read user input from the console.
 * It uses a Scanner to read input and validates that the input is an integer.
 * 
 * This class is not a good candidate for unit testing because it relies on console input, which is difficult to mock or stub.
 * However, it is a simple implementation that serves the purpose of reading user input for the flashcard application, and we have implemented an
 * interface so that we can easily mock the interface in unit tests on other classes that depend on it.
 */
@Component
public class ConsoleUserInputReaderImpl implements UserInputReader {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public int getUserInputInt(String prompt) {
        System.out.print(prompt);
        String line = scanner.nextLine();
        while (!line.matches("\\d+")) {
            System.out.print("Invalid input. Please enter a number: ");
            line = scanner.nextLine();
        }
        return Integer.parseInt(line);
    }
}
