package com.sporcle.enums;

public enum PageTitle {
    SEARCH("Sporcle Search for ''"),
    HOME("Sporcle | Play Fun Trivia Quizzes on Every Topic"),
    EVENTS("Free Pub Trivia - Sporcle Events"),
    QUIZ_CREATION("Create a Free Online Quiz"),
    COMMUNITY("Sporcle Discussion Boards - Mentally Stimulating Conversations"),
    VIDEOS("Sporcle Videos"),
    PRIVATE_EVENTS("Trivia Hosting For Your Next Party or Event | In-Person or Virtually"),
    REMOVE_ADS("Memberships on Sporcle"),
    COMMUNITY_GUIDELINES("Community Guidelines"),
    CONTINUE_WITH_GOOGLE("Вход – Google Аккаунты"),
    CONTINUE_WITH_APPLE("Вход в Аккаунт Apple"),
    FORGOT_PASSWORD("Forgot Password on Sporcle"),
    FACEBOOK_ACCOUNT("Update your Sporcle Account");

    private final String title;

    PageTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
