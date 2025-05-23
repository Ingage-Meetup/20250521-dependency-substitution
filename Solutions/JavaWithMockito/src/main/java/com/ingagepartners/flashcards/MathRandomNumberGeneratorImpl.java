package com.ingagepartners.flashcards;

import org.springframework.stereotype.Component;

/**
 * This class implements the RandomNumberGenerator interface using Math.random() to generate random numbers.
 * It is a Spring component, which means it can be injected into other components or services.
 * 
 * This class is not a good candidate for unit testing because it uses Math.random(), which is a static method and does not allow for easy mocking or stubbing.
 * However, it is a simple implementation that serves the purpose of generating random numbers for the flashcard application, and we have implemented an
 * interface so that we can easily mock the interface in unit tests on other classes that depend on it.
 */
@Component
public class MathRandomNumberGeneratorImpl implements RandomNumberGenerator {

    @Override
    public int getRandomNumber(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }
}
