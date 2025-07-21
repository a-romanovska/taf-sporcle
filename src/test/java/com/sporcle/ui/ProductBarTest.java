package com.sporcle.ui;

import com.sporcle.ui.pages.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductBarTest extends BaseTest {
    @Override
    @BeforeEach
    public void setUp() {
        openProductBarForm();
    }

    @Test
    public void testOpenQuizzesPage() {
        productBarForm.clickQuizzesButton();
        checkThatCurrentPageIsExpectedOne(homePage);
    }

    @Test
    public void testOpenEventsPage() {
        productBarForm.clickEventsButton();
        checkThatCurrentPageIsExpectedOne(new EventsPage());
    }

    @Test
    public void testOpenQuizCreationPage() {
        productBarForm.clickQuizCreationButton();
        checkThatCurrentPageIsExpectedOne(new QuizCreationPage());
    }

    @Test
    public void testOpenCommunityPage() {
        productBarForm.clickCommunityButton();
        checkThatCurrentPageIsExpectedOne(new CommunityPage());
    }

    @Test
    public void testOpenVideosPage() {
        productBarForm.clickVideosButton();
        checkThatCurrentPageIsExpectedOne(new VideosPage());
    }

    @Test
    public void testOpenPrivateEventsPage() {
        productBarForm.clickPrivateEventsButton();
        checkThatCurrentPageIsExpectedOne(new PrivateEventsPage());
    }

    @Test
    public void testOpenRemoveAdsPage() {
        productBarForm.clickRemoveAdsButton();
        //productBarForm.clickRemoveAdsButton();//добавила клик
        checkThatCurrentPageIsExpectedOne(new RemoveAdsPage());
    }

    @Test
    public void testOpenLogInForm() {
        productBarForm.clickLogInButton();
        checkThatLogInFormIsVisible();
    }

    @Test
    public void openSettingsForm() {
        productBarForm.clickSettingsButton();
        checkThatSettingsFormIsVisible();
    }
}
