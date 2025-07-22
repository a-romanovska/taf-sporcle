package com.sporcle.enums;

public enum ErrorMessage {
    LOGIN_MISSING_EMAIL("Missing email or username"),
    LOGIN_MISSING_PASSWORD("Missing password"),
    LOGIN_MISSING_EMAIL_OR_PASSWORD("Missing email or password"),
    LOGIN_INCORRECT_INFORMATION("Incorrect login information"),
    LOGIN_INCORRECT_INFORMATION_GENERAL("Incorrect login information."),
    SEARCH_NO_QUIZZES_FOUND("No quizzes found matching");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
