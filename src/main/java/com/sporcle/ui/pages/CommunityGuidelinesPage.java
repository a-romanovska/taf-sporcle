package com.sporcle.ui.pages;

import com.sporcle.enums.PageTitle;
import com.sporcle.ui.Endpoints;

public class CommunityGuidelinesPage extends BasePage {
    public CommunityGuidelinesPage() {
        super(Endpoints.COMMUNITY_GUIDELINES, PageTitle.COMMUNITY_GUIDELINES.getTitle());
    }
}
