package com.sporcle.api.pages;

import com.sporcle.api.Endpoints;

import java.net.HttpURLConnection;

import static io.restassured.RestAssured.given;

public class SearchPage {
    private final String gameTitleCss = "a.gameName";
    private final String gameDescriptionCss = "p.gameDesc";
    private final String noQuizzesFoundMessageCss = "#content h2";
    private final String search = "s";
    private final String page = "p";
    private final String pageNumber = "1";

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
                .queryParam(search, query)
                .queryParam(page, pageNumber)
                .when()
                .get(Endpoints.SEARCH)
                .then()
                .statusCode(HttpURLConnection.HTTP_OK)
                .extract().response()
                .getBody().asString();
    }
}
