package com.sporcle.api;

import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class SearchForm extends ApiForm {
    private static final String URL_SEARCH = URL_BASE + "/search/quizzes/?s=Banana";

    public SearchForm(String propertiesFileName) {
        super(propertiesFileName);
    }

    @Override
    protected Response getResponse() {
        return getResponse(URL_SEARCH, getContentTypeHeader(), getFormParams());
    }

    @Override
    protected Map<String, String> getContentTypeHeader() {
        Map<String, String> header = new HashMap<>();
        return header;
    }

    @Override
    protected Map<String, String> getFormParams() {
        Properties properties = new Properties();
        return super.getFormParams(properties);
    }
}
