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
        searchValue = searchValue.trim().toUpperCase();

        String[] searchWords = searchValue.split("\\s+");

        for (String word : searchWords) {
            logger.info("Actual: " + actualGameTitleText);
            logger.info("Word: " + word);
            Assertions.assertTrue(actualGameTitleText.contains(word), "Actual game title does not contain such word");
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