package com.sporcle.api.pages;

import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

public abstract class BasePage {
    protected String URL;
    protected String usedPropertiesFileName;
    protected static Logger logger = LogManager.getLogger();

    protected BasePage(String endpoint, String usedPropertiesFileName) {
        this.URL = endpoint;
        this.usedPropertiesFileName = usedPropertiesFileName;
    }

    protected abstract Response getResponse();

    protected abstract Map<String, String> getContentTypeHeader();

    protected abstract Map<String, String> getFormParams();

    public int getStatusCode() {
        return getResponse().getStatusCode();
    }
}
