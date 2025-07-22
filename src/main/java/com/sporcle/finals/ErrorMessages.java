package com.sporcle.finals;

public enum ErrorMessages {
    LOGIN_MISSING_EMAIL("Missing email or username"),
    LOGIN_MISSING_PASSWORD("Missing password"),
    LOGIN_MISSING_EMAIL_OR_PASSWORD("Missing email or password"),
    LOGIN_INCORRECT_INFORMATION("Incorrect login information"),
    LOGIN_INCORRECT_INFORMATION_GENERAL("Incorrect login information."),
    SEARCH_NO_QUIZZES_FOUND("No quizzes found matching");

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
