package com.sporcle.ui;

import com.sporcle.ui.forms.ProductBarForm;
import com.sporcle.ui.pages.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductBarTest extends BaseTest {
    private ProductBarForm productBarForm;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        productBarForm = homePage.getProductBarFormWhenVisible();
    }
    //добавить Step для setUp открытий если вынести в отдельные методы?

    @Test
    public void testOpenQuizzesPage() {
        productBarForm.clickQuizzesButton();
        checkThatCurrentPageIsExpectedOne(homePage);
    }

    @Test
    public void testOpenEventsPage() {
        productBarForm.clickEventsButton();
        EventsPage eventsPage = new EventsPage();
        checkThatCurrentPageIsExpectedOne(eventsPage);
    }

    @Test
    public void testOpenQuizCreationPage() {
        productBarForm.clickQuizCreationButton();
        QuizCreationPage quizCreationPage = new QuizCreationPage();
        checkThatCurrentPageIsExpectedOne(quizCreationPage);
    }

    @Test
    public void testOpenCommunityPage() {
        productBarForm.clickCommunityButton();
        CommunityPage communityPage = new CommunityPage();
        checkThatCurrentPageIsExpectedOne(communityPage);
    }

    @Test
    public void testOpenVideosPage() {
        productBarForm.clickVideosButton();
        VideosPage videosPage = new VideosPage();
        checkThatCurrentPageIsExpectedOne(videosPage);
    }

    @Test
    public void testOpenPrivateEventsPage() {
        productBarForm.clickPrivateEventsButton();
        PrivateEventsPage privateEventsPage = new PrivateEventsPage();
        checkThatCurrentPageIsExpectedOne(privateEventsPage);
    }

    @Test
    public void testOpenRemoveAdsPage() {
        productBarForm.clickRemoveAdsButton();
        RemoveAdsPage removeAdsPage = new RemoveAdsPage();
        checkThatCurrentPageIsExpectedOne(removeAdsPage);
    }

    //может отовсюду убрать обязательное ожидание и оставить только там, где требуется, чтоб ускорить тесты?
    //стал фейлиться + убрать комментирование
    @Test
    public void testOpenLogInForm() {
        productBarForm.clickLogInButton();
        Assertions.assertTrue(homePage.logInFormIsVisible());//добавить Step после того как вынесу
    }

    @Test
    public void openSettingsForm() {
        productBarForm.clickSettingsButton();
        Assertions.assertTrue(homePage.settingsFormIsVisible());
    }
}
