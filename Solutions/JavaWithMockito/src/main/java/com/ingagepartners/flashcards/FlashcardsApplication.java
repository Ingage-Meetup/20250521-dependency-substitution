package com.ingagepartners.flashcards;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This is the Spring Boot main class for the Flashcards application. This will not have unit tests
 * because it is the entry point of the application and does not contain any business logic.
 */
@SpringBootApplication
public class FlashcardsApplication implements CommandLineRunner{
	@Autowired
	private FlashcardsSession flashcardsSession;

	public static void main(String[] args) {
		SpringApplication.run(FlashcardsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var results = flashcardsSession.runSession();
		System.out.println("You got " + results.getCorrectAnswers() + " out of " + results.getTotalCards() + " correct!");
	}
}
