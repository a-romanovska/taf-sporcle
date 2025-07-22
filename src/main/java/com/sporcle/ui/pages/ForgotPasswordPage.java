package com.sporcle.ui.pages;

import com.sporcle.enums.PageTitle;
import com.sporcle.ui.Endpoints;

public class ForgotPasswordPage extends BasePage {
    public ForgotPasswordPage() {
        super(Endpoints.FORGOT_PASSWORD, PageTitle.FORGOT_PASSWORD.getTitle());
    }
}
