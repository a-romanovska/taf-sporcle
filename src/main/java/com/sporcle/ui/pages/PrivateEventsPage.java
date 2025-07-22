package com.sporcle.ui.pages;

import com.sporcle.enums.PageTitle;
import com.sporcle.ui.Endpoints;

public class PrivateEventsPage extends BasePage {
    public PrivateEventsPage() {
        super(Endpoints.PRIVATE_EVENTS, PageTitle.PRIVATE_EVENTS.getTitle());
    }
}
