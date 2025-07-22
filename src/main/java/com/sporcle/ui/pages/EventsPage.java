package com.sporcle.ui.pages;

import com.sporcle.enums.PageTitle;
import com.sporcle.ui.Endpoints;

public class EventsPage extends BasePage {
    public EventsPage() {
        super(Endpoints.EVENTS, PageTitle.EVENTS.getTitle());
    }
}
