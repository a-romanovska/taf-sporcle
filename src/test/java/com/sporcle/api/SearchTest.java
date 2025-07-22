package com.sporcle.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class SearchTest extends BaseTest {
    private String searchValue = "Banana";

    @Test
    public void testSearch() {
        String body = given()
                .queryParam("s", "Banana")
                .queryParam("p", "1")
                .when().get("https://www.sporcle.com/search/")
                .then()
                .statusCode(200)
                .extract().response()
                .body().asString();

        Assertions.assertTrue(body.contains(searchValue), searchValue + " is not found");
    }
}
