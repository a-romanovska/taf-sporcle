package com.sporcle.ui.finals;

public class TEMPORARY {
    //xpath для LogInForm
    private static class LogInFormLocators {
        //не получается закрыть окно нажатием вне, локатор не подходит?
        private static final String LOG_IN_MODAL_WRAPPER = "//div[@class='modal-wrapper is-opened']";

        private static final String LOG_IN_MODAL_HEADER = "//h2[@class='modal-title']";

        //private static final String LOG_IN_MODAL_CLOSE_BUTTON = "//button[@class='modal-close']";

        private static final String LOG_IN_MODAL_COMMUNITY_GUIDELINES_TEXT = "//div[@class='community-guidelines-text']";
        private static final String LOG_IN_MODAL_COMMUNITY_GUIDELINES_LINK = LOG_IN_MODAL_COMMUNITY_GUIDELINES_TEXT + "//a[@href='/community/']";

        private static final String CONTINUE_WITH_GOOGLE_BUTTON = "//button[@data-onsuccess='googleSignIn']";
        //private static final String LOG_IN_VIA_GOOGLE_BUTTON = "//button[@class='signup-button google-signup-button initGoogleLogin']";
        private static final String CONTINUE_WITH_GOOGLE_BUTTON_TEXT = CONTINUE_WITH_GOOGLE_BUTTON + "//span[@class='signup-button-text']";

        private static final String CONTINUE_WITH_APPLE_BUTTON = "//button[@id='apple-signin']";
        //private static final String LOG_IN_VIA_APPLE_BUTTON = "//button[@class='signup-button google-signup-button initGoogleLogin']";
        private static final String CONTINUE_WITH_APPLE_BUTTON_TEXT = CONTINUE_WITH_APPLE_BUTTON + "//span[@class='signup-button-text']";

        //нужно ли переименовать локатор?
        private static final String CONTINUE_WITH_FACEBOOK_TEXT = "//div[@class='facebook-text']";
        private static final String CONTINUE_WITH_FACEBOOK_LINK = CONTINUE_WITH_FACEBOOK_TEXT + "//a[@href='/facebook-account/']";

        private static final String LOG_IN_MODAL_DIVIDING_LINE = "//div[@class='dividing-line']";
        private static final String LOG_IN_MODAL_DIVIDING_LINE_TEXT = LOG_IN_MODAL_DIVIDING_LINE + "//span[@class='text']";

        private static final String REQUIRED_FIELD_ASTERISK = "//span[@class='asterisk']";

        //private static final String EMAIL_FIELD_LABEL = "//label[@for='email']";
        //private static final String EMAIL_FIELD_LABEL_ASTERISK = EMAIL_FIELD_LABEL + REQUIRED_FIELD_ASTERISK;

        //private static final String PASSWORD_FIELD_LABEL = "//label[@for='password']";
        //private static final String PASSWORD_FIELD_LABEL_ASTERISK = PASSWORD_FIELD_LABEL + REQUIRED_FIELD_ASTERISK;

        private static final String STAY_SIGNED_IN_CHECKBOX = "//input[@id='remember-me']";
        private static final String STAY_SIGNED_IN_LABEL = "//label[@for='remember-me']";
        private static final String STAY_SIGNED_IN_CHECKBOX_WITH_LABEL = STAY_SIGNED_IN_CHECKBOX + "/parent::div";

        private static final String REQUIRED_FIELD_INDICATOR_TEXT = "//p[@class='asterik-text']";

        private static final String FORGOT_PASSWORD_LINK = "//a[@href='/forgot/']";

        private static final String JOIN_FOR_FREE_BUTTON = "//button[@id='switch-to-join-modal']";
    }

    //тексты с элементов для LogInForm
    public static class CorrectTexts {
        public static final String HEADER_TEXT_CORRECT = "Log In";
        public static final String COMMUNITY_GUIDELINES_TEXT_CORRECT = "By continuing you agree to our ";
        public static final String COMMUNITY_GUIDELINES_LINK_TEXT_CORRECT = "Community Guidelines";
        public static final String CONTINUE_WITH_GOOGLE_BUTTON_TEXT_CORRECT = "Continue with Google".toUpperCase();
        public static final String CONTINUE_WITH_APPLE_BUTTON_TEXT_CORRECT = "Continue with Apple".toUpperCase();
        public static final String CONTINUE_WITH_FACEBOOK_TEXT_CORRECT = "Created your account with Facebook? ";
        public static final String CONTINUE_WITH_FACEBOOK_LINK_TEXT_CORRECT = "Go Here";
        public static final String LOG_IN_BUTTON_TEXT_CORRECT = "Log In";
    }

    //xpath для HomePage
    private static class HomePageLocators {
        //базовая страница
        private static final String SIGN_IN_BUTTON = "//button[@id='user-not-logged-in']";
        //ежедневная реклама
        /*Если реклама меняется ежедневно, то можно попробовать работать через постоянный DISMISSIBLE_MODAL
         * или присваивать DISMISSIBLE_MODAL значение сегодняшней модалки
         * Проверитт, нужно ли ознакамливаться с окном раз в день или постоянно
         * (при нажатии X или Dismiss)*/
        private static final String DAILY_DISMISSIBLE_MODAL = "//div[@class='modal dismissible is-opened']";
        private static final String DAILY_TOURNAMENT_TAKEOVER_MODAL = "//div[@id='tournament-takeover-modal']";
        private static final String DAILY_DISMISSIBLE_MODAL_CLOSE_BUTTON = "//button[@data-modal-action='close']";
        //private static final String DAILY_DISMISSIBLE_MODAL_CLOSE_BUTTON="//button[@class='modal-close']";
        //private static final String DAILY_DISMISS_BUTTON = By.xpath("//button[@id='no']");
    }
}
