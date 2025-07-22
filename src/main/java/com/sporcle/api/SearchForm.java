package com.sporcle.api;

import static io.restassured.RestAssured.given;

public class SearchForm {
    /*private static final String URL_SEARCH = URL_BASE + "/search/quizzes/?s=Banana";

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
    }*/

    public String doSearch(String query) {
        return given()
                .queryParam("s", query)
                .queryParam("p", "1")
                .when().get("https://www.sporcle.com/search/")
                .then()
                .statusCode(200)
                .extract().response()
                .getBody().asString();
    }
}
