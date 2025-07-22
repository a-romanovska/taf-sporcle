package com.sporcle.ui.pages;

import com.sporcle.enums.PageTitle;
import com.sporcle.ui.finals.Endpoints;

public class ContinueWithGooglePage extends BasePage {
    public ContinueWithGooglePage() {
        super(Endpoints.PART_OF_CONTINUE_WITH_GOOGLE, PageTitle.CONTINUE_WITH_GOOGLE.getTitle());
    }
}
