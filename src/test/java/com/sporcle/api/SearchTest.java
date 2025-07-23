package com.sporcle.api;

import com.sporcle.api.pages.SearchPage;
import com.sporcle.enums.ErrorMessage;
import com.sporcle.enums.Symbol;
import io.qameta.allure.Step;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.junit.jupiter.api.Assertions.assertAll;

public class SearchTest extends BaseTest {
    private SearchPage searchPage;
    private String searchValue;
    private final String oneWord = "apple";
    private final String twoWords = "Word Ladder";
    private final String moreThanTwoWords = "Pic winner 30";
    private final String emptyWord = Symbol.EMPTY.getSymbol();
    private final String wordWithSpaceBeforeAndAfter = " dog ";
    private final String spaceWord = Symbol.SPACE.getSymbol();
    private final String nonExistentWord = "kdakdksad";

    @Override
    @BeforeEach
    protected void setUp() {
        searchPage = new SearchPage();
    }

    @Test
    public void testSearchOneWord() {
        searchValue = oneWord;
        checkSearchResult();
    }

    @Test
    public void testSearchTwoWordsWithSpace() {
        searchValue = twoWords;
        checkSearchResult();
    }

    @Test
    public void testSearchMoreThanTwoWords() {
        searchValue = moreThanTwoWords;
        checkSearchResult();
    }

    @Test
    public void testSearchEmptyWord() {
        searchValue = emptyWord;
        checkSearchResult();
    }

    @Test
    public void testSearchWordWithSpaceBeforeAndAfter() {
        searchValue = wordWithSpaceBeforeAndAfter;
        checkSearchResult();
    }

    @Test
    public void testSearchSpaceWord() {
        searchValue = spaceWord;
        checkSearchResult();
    }

    @Test
    public void testSearchNonExistentWord() {
        searchValue = nonExistentWord;
        checkNoQuizzesFoundMessage();
    }

    @Step("Check that search result is correct")
    private void checkSearchResult() {
        logger.info("SearchValue is '{}'", searchValue);

        String responseHtml = searchPage.doSearch(searchValue);

        Document doc = Jsoup.parse(responseHtml);
        Element gameTitle = doc.selectFirst(searchPage.getGameTitleCss());
        Element gameDescription = doc.selectFirst(searchPage.getGameDescriptionCss());

        try {
            Assertions.assertTrue(arePresent(gameTitle, gameDescription), "No quizzes are displayed");
        } catch (AssertionError error) {
            return;
        }

        if (searchValue.isEmpty() || searchValue.equals(Symbol.SPACE.getSymbol())) {
            logger.info("Random quizzes are shown for empty SearchValue - correct");
            return;
        }

        boolean wordIsPresentInResult;
        String gameTitleText = gameTitle.text().toUpperCase();
        String gameDescriptionText = gameDescription.text().toUpperCase();
        String[] wordsFromSearchValue = searchValue.trim().toUpperCase().split("\\s+");

        for (String word : wordsFromSearchValue) {
            wordIsPresentInResult = false;

            if (gameTitleText.contains(word) || gameDescriptionText.contains(word)) {
                logger.info("Word '{}' was found", searchValue);
                wordIsPresentInResult = true;
            }
            Assertions.assertTrue(wordIsPresentInResult, "Game title and description do not contain " + word);
        }
    }

    @Step("Check that 'No quizzes found' message is displayed instead of search result")
    private void checkNoQuizzesFoundMessage() {
        logger.info("SearchValue is '{}'", searchValue);

        String responseHtml = searchPage.doSearch(searchValue);

        Document doc = Jsoup.parse(responseHtml);
        Element noQuizzesFoundMessage = doc.selectFirst(searchPage.getNoQuizzesFoundMessageCss());

        try {
            Assertions.assertTrue(isPresent(noQuizzesFoundMessage), "No message is displayed");
        } catch (AssertionError error) {
            return;
        }

        logger.info("Some message is displayed for non-existent SearchValue - correct");

        searchValue = searchValue.trim();

        String actualMessageText = noQuizzesFoundMessage.text();
        assertAll(
                () -> Assertions.assertEquals(HttpURLConnection.HTTP_OK, searchPage.getStatusCode()),
                () -> Assertions.assertTrue(actualMessageText.contains(ErrorMessage.SEARCH_NO_QUIZZES_FOUND.getMessage()), "Incorrect message text"),
                () -> Assertions.assertTrue(actualMessageText.contains(searchValue), "Incorrect SearchValue in message text")
        );
    }

    private boolean arePresent(Element gameTitle, Element gameDescription) {
        if (gameTitle == null) {
            logger.info("<a class='gameName'> is not found");
            return false;
        }
        if (gameDescription == null) {
            logger.info("<p class='gameDesc'> is not found");
            return false;
        }
        return true;
    }

    private boolean isPresent(Element noQuizzesFoundMessage) {
        if (noQuizzesFoundMessage == null) {
            logger.info("No <h2> element found within the #content section.");
            return false;
        }
        return true;
    }
}
