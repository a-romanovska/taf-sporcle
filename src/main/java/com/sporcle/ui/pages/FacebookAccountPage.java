package com.sporcle.ui.pages;

import com.sporcle.enums.PageTitle;
import com.sporcle.ui.Endpoints;

public class FacebookAccountPage extends BasePage {
    public FacebookAccountPage() {
        super(Endpoints.FACEBOOK_ACCOUNT, PageTitle.FACEBOOK_ACCOUNT.getTitle());
    }
}
