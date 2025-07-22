package com.sporcle.api;

import static io.restassured.RestAssured.given;

public class SearchForm {
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
