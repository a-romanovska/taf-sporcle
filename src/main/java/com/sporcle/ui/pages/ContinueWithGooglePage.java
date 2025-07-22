package com.sporcle.ui.pages;

import com.sporcle.enums.PageTitle;
import com.sporcle.ui.Endpoints;

public class ContinueWithGooglePage extends BasePage {
    public ContinueWithGooglePage() {
        super(Endpoints.CONTINUE_WITH_GOOGLE, PageTitle.CONTINUE_WITH_GOOGLE.getTitle());
    }
}
