package com.sporcle.ui.pages;

import com.sporcle.enums.PageTitle;
import com.sporcle.ui.Endpoints;

public class RemoveAdsPage extends BasePage{
    public RemoveAdsPage() {
        super(Endpoints.REMOVE_ADS, PageTitle.REMOVE_ADS.getTitle());
    }
}
