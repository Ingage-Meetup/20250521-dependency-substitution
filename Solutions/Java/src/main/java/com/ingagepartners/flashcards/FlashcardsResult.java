package com.ingagepartners.flashcards;

public class FlashcardsResult {
    private final int totalCards;
    private int correctAnswers;
    private int incorrectAnswers;

    public FlashcardsResult(int totalCards) {
        this.totalCards = totalCards;
        this.correctAnswers = 0;
        this.incorrectAnswers = 0;
    }

    public void incrementCorrectAnswers() {
        this.correctAnswers++;
    }
    public void incrementIncorrectAnswers() {
        this.incorrectAnswers++;
    }
    public int getTotalCards() {
        return totalCards;
    }
    public int getCorrectAnswers() {
        return correctAnswers;
    }
    public int getIncorrectAnswers() {
        return incorrectAnswers;
    }
}
