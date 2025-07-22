package com.sporcle.ui.pages;

import com.sporcle.enums.PageTitle;
import com.sporcle.ui.finals.Endpoints;

public class QuizCreationPage extends BasePage {
    public QuizCreationPage() {
        super(Endpoints.QUIZ_CREATION, PageTitle.QUIZ_CREATION.getTitle());
    }
}
