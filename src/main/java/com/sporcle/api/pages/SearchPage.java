package com.sporcle.api.pages;

import com.sporcle.api.Endpoints;
import com.sporcle.enums.Symbol;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class SearchPage extends BasePage {
    private final String gameTitleCss = "a.gameName";
    private final String gameDescriptionCss = "p.gameDesc";
    private final String noQuizzesFoundMessageCss = "#content h2";
    private final String search = "s";
    private final String page = "p";
    private final String pageNumber = "1";
    private String currentQuery = Symbol.EMPTY.getSymbol();

    public SearchPage() {
        super(Endpoints.SEARCH);
    }

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
        return getResponse(query).getBody().asString();
    }

    private Response getResponse(String query) {
        currentQuery = query;
        return getResponse();
    }

    @Override
    protected Response getResponse() {
        return given()
                .queryParam(search, currentQuery)
                .queryParam(page, pageNumber)
                .when()
                .get(URL)
                .then()
                .extract().response();
    }
}
