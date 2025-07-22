package com.sporcle.api;

import com.sporcle.finals.ErrorMessages;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;

public class SearchTest extends BaseTest {
    private String searchValue;

    @Test
    public void testSearchOneWord() {
        searchValue = "apple";
        checkSearchResults();
    }

    @Test
    public void testSearchTwoWordsWithSpace() {
        searchValue = "Word Ladder";
        checkSearchResults();
    }

    @Test
    public void testSearchMoreThanTwoWords() {
        searchValue = "Pic winner 30";
        checkSearchResults();
    }

    @Test
    public void testSearchEmptyWord() {
        searchValue = "";
        checkSearchResults();
    }

    @Test
    public void testSearchWordWithSpaceBeforeAndAfter() {
        searchValue = " dog ";
        checkSearchResults();
    }

    @Test
    public void testSearchSpaceWord() {
        searchValue = " ";
        checkSearchResults();
    }

    @Test
    public void testSearchNonExistentWord() {
        searchValue = "kdakdksad";
        checkNoQuizzesFoundMessage();
    }

    private boolean gameTitleAndDescriptionLinksAreNotNull(Element gameTitleLink, Element gameDescriptionLink) {
        if (gameTitleLink == null) {
            logger.info(" <a class='gameName'> is not found");
            return false;
        }
        if (gameDescriptionLink == null) {
            logger.info(" <p class='gameDesc'> is not found");
            return false;
        }
        return true;
    }

    public void checkSearchResults() {
        SearchForm searchForm = new SearchForm();
        String htmlBodyAsString = searchForm.doSearch(searchValue);

        Document doc = Jsoup.parse(htmlBodyAsString);
        Element gameTitleLink = doc.selectFirst("a.gameName");
        Element gameDescriptionLink = doc.selectFirst("p.gameDesc");

        boolean found = false;

        if (gameTitleAndDescriptionLinksAreNotNull(gameTitleLink, gameDescriptionLink)) {
            String[] searchWords = searchValue.trim().toUpperCase().split("\\s+");

            String gameTitleText = gameTitleLink.text().toUpperCase();
            String gameDescriptionText = gameDescriptionLink.text().toUpperCase();

            for (String word : searchWords) {

                found = false;

                if (gameTitleText.contains(word) || gameDescriptionText.contains(word)) {
                    logger.info("Word '" + word + "' was found");
                    found = true;
                }
            }
        }

        Assertions.assertTrue(found, "Nothing found for '" + searchValue + "'");
    }

    private boolean gameNoQuizzesFoundMessageIsNotNull(Element noQuizzesFoundMessage) {
        if (noQuizzesFoundMessage == null) {
            logger.info("No <h2> element found within the #content section.");
            return false;
        }
        return true;
    }

    public void checkNoQuizzesFoundMessage() {
        SearchForm searchForm = new SearchForm();
        String htmlBodyAsString = searchForm.doSearch(searchValue);

        Document doc = Jsoup.parse(htmlBodyAsString);
        Element noQuizzesFoundMessage = doc.selectFirst("#content h2");

        if (gameNoQuizzesFoundMessageIsNotNull(noQuizzesFoundMessage)) {
            searchValue = searchValue.trim().toUpperCase();

            String noQuizzesFoundMessageText = noQuizzesFoundMessage.text().toUpperCase();

            assertAll(
                    () -> Assertions.assertTrue(noQuizzesFoundMessageText.contains(ErrorMessages.SEARCH_NO_QUIZZES_FOUND.toUpperCase()), "Incorrect message test"),
                    () -> Assertions.assertTrue(noQuizzesFoundMessageText.contains(searchValue), "Incorrect message test")
            );
        }
    }
}
