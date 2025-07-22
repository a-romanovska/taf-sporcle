package com.sporcle.ui.pages;

import com.sporcle.enums.PageTitle;
import com.sporcle.ui.Endpoints;

public class CommunityPage extends BasePage {
    public CommunityPage() {
        super(Endpoints.COMMUNITY, PageTitle.COMMUNITY.getTitle());
    }
}
