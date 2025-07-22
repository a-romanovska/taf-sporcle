package com.sporcle.cucumber;

import com.sporcle.finals.ErrorMessages;
import com.sporcle.ui.BaseTest;
import com.sporcle.ui.forms.SearchContentForm;
import com.sporcle.ui.pages.SearchPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertAll;

public class Hooks extends BaseTest {
    public static SearchPage searchPage;
    public static String searchValue;

    @Before
    public void openSearchPage() {
        openContextBarForm();
        searchPage = new SearchPage();
    }

    @After
    public void afterScenario() {
        quitDriver();
    }

    @When("Input {string} into Search bar")
    public void inputSearchValue(String value) {
        searchValue = value;
        homePageContextBarForm.clickStartLoupeButton();
        homePageContextBarForm.inputSearchInputField(searchValue);
        homePageContextBarForm.clickInputLoupeButton();
    }

    @Then("Check search results")
    public void checkSearchResults() {
        SearchContentForm searchContentForm = searchPage.getSearchContentFormWhenVisible();
        String actualGameTitleText = searchContentForm.getSearchResult1GameTitleText().toUpperCase();
        String actualGameDescriptionText = searchContentForm.getSearchResult1GameDescriptionText().toUpperCase();
        searchValue = searchValue.trim().toUpperCase();

        String[] searchWords = searchValue.split("\\s+");

        logger.info("Actual title: " + actualGameTitleText);
        logger.info("Actual description: " + actualGameDescriptionText);

        boolean found;
        for (String word : searchWords) {
            logger.info("Search word: " + word);

            found = false;

            if (actualGameTitleText.contains(word) || actualGameDescriptionText.contains(word)) {
                System.out.println("Word '" + word + "' was found");
                found = true;
            }

            Assertions.assertTrue(found, "Actual game title and description do not contain such word");
        }
    }

    @Then("Check 'No quizzes found' message")
    public void checkNoQuizzesFoundMessage() {
        SearchContentForm searchContentForm = searchPage.getSearchContentFormWhenVisible();
        String actualMessageText = searchContentForm.getNoQuizzesFoundMessageText().toUpperCase();
        searchValue = searchValue.trim().toUpperCase();

        assertAll(
                () -> Assertions.assertTrue(actualMessageText.contains(ErrorMessages.SEARCH_NO_QUIZZES_FOUND.toUpperCase()), "Incorrect message test"),
                () -> Assertions.assertTrue(actualMessageText.contains(searchValue), "Incorrect message test")
        );
    }
}