package com.sporcle.api;

import com.sporcle.api.finals.Endpoints;

import static io.restassured.RestAssured.given;

public class SearchForm {
    public String doSearch(String query) {
        return given()
                .queryParam("s", query)
                .queryParam("p", "1")
                .when().get(Endpoints.SEARCH)
                .then()
                .statusCode(200)
                .extract().response()
                .getBody().asString();
    }
}
