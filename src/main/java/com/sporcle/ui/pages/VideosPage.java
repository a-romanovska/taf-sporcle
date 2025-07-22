package com.sporcle.ui.pages;

import com.sporcle.enums.PageTitle;
import com.sporcle.ui.Endpoints;

public class VideosPage extends BasePage {
    public VideosPage() {
        super(Endpoints.VIDEOS, PageTitle.VIDEOS.getTitle());
    }
}
