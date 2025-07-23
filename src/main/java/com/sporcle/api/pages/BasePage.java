package com.sporcle.api.pages;

import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class BasePage {
    protected String URL;
    protected static Logger logger = LogManager.getLogger();

    protected BasePage(String endpoint) {
        this.URL = endpoint;
    }

    public int getStatusCode() {
        return getResponse().getStatusCode();
    }

    protected abstract Response getResponse();
}
