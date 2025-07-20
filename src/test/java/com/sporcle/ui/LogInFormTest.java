package com.sporcle.ui;

import com.sporcle.ui.pages.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LogInFormTest extends BaseTest {
    @BeforeEach
    public void setUp() {
        openLogInForm();
    }

    @Test
    public void testCloseLogInFormViaCloseButton() {
        logInForm.clickCloseButton();
        //Assertions.assertTrue(homePage.logInFormIsInvisible());
        checkThatFormIsVisible(homePage.logInFormIsVisible());
    }

    @Test
    public void testContinueWithGoogleWindowOpen() {
        logInForm.clickContinueWithGoogleButton();
        checkThatNewWindowIsOpened(new ContinueWithGooglePage());
    }

    @Test
    public void testContinueWithAppleWindowOpen() {
        logInForm.clickContinueWithAppleButton();
        checkThatNewWindowIsOpened(new ContinueWithApplePage());
    }

    @Test
    public void testCommunityGuidelinesPageOpen() {
        logInForm.clickCommunityGuidelinesButton();
        checkThatCurrentPageIsExpectedOne(new CommunityGuidelinesPage());
    }

    @Test
    public void testRegistrationFormOpen() {
        logInForm.clickJoinSporcleForFreeButton();
        //Assertions.assertTrue(homePage.registrationFormIsVisible());
        checkThatFormIsVisible(homePage.registrationFormIsVisible());
    }

    @Test
    public void testForgotPasswordPageOpen() {
        logInForm.clickGForgotPasswordButton();
        checkThatCurrentPageIsExpectedOne(new ForgotPasswordPage());
    }

    @Test
    public void testFacebookAccountPageOpen() {
        logInForm.clickGoHereButton();
        checkThatCurrentPageIsExpectedOne(new FacebookAccountPage());
    }
}
