package com.sporcle.api;

import com.sporcle.api.finals.Endpoints;

import static io.restassured.RestAssured.given;

public class SearchPage {
    private final String gameTitleCss = "a.gameName";
    private final String gameDescriptionCss = "p.gameDesc";
    private final String noQuizzesFoundMessageCss = "#content h2";

    public String getGameTitleCss() {
        return gameTitleCss;
    }

    public String getGameDescriptionCss() {
        return gameDescriptionCss;
    }

    public String getNoQuizzesFoundMessageCss() {
        return noQuizzesFoundMessageCss;
    }

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
