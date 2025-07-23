package com.sporcle.ui.cucumber;

import com.sporcle.enums.ErrorMessage;
import com.sporcle.ui.BaseTest;
import com.sporcle.ui.forms.ProductBarForm;
import com.sporcle.ui.forms.SearchContentForm;
import com.sporcle.ui.pages.SearchPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertAll;

public class Steps extends BaseTest {
    private ProductBarForm productBarForm;
    private SearchPage searchPage;
    private String searchValue;
    private final BaseTest baseTest = new BaseTest();

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
        SearchContentForm searchContentForm;

        try {
            searchContentForm = searchPage.getSearchContentFormWhenVisible();
        } catch (Exception error) {
            logger.info("No quizzes are displayed");
            return;
        }

        if (searchValue.isEmpty() || searchValue.equals(" ")) {
            logger.info("Random quizzes are shown for empty SearchValue - correct");
            return;
        }

        boolean wordIsPresentInResult;
        String gameTitleText = searchContentForm.getSearchResultGameTitleText().toUpperCase();
        String gameDescriptionText = searchContentForm.getSearchResultGameDescriptionText().toUpperCase();
        String[] wordsFromSearchValue = searchValue.trim().toUpperCase().split("\\s+");

        logger.info("Actual title: {}", gameTitleText);
        logger.info("Actual description: {}", gameDescriptionText);

        for (String word : wordsFromSearchValue) {
            wordIsPresentInResult = false;

            if (gameTitleText.contains(word) || gameDescriptionText.contains(word)) {
                logger.info("Word '{}' was found", word);
                wordIsPresentInResult = true;
            }
            Assertions.assertTrue(wordIsPresentInResult, String.format("Game title and description do not contain %s", word));
        }
    }

    @Then("Check 'No quizzes found' message")
    public void checkNoQuizzesFoundMessage() {
        SearchContentForm searchContentForm;

        try {
            searchContentForm = searchPage.getSearchContentFormWhenVisible();
        } catch (Exception error) {
            logger.info("No message is displayed");
            return;
        }

        logger.info("Some message is displayed for non-existent SearchValue - correct");

        String actualMessageText = searchContentForm.getNoQuizzesFoundMessageText().toUpperCase();
        String expectedMessageText = ErrorMessage.SEARCH_NO_QUIZZES_FOUND.getMessage().toUpperCase();
        searchValue = searchValue.trim().toUpperCase();

        assertAll(
                () -> Assertions.assertTrue(actualMessageText.contains(expectedMessageText), "Incorrect message test"),
                () -> Assertions.assertTrue(actualMessageText.contains(searchValue), "Incorrect SearchValue in message text")
        );
    }

    @Given("Open ProductBar")
    public void openProductBar() {
        productBarForm = baseTest.openProductBarForm();
    }

    @When("Click [Sign In] on ProductBar")
    public void clickSignInOnProductBar() {
        productBarForm.clickLogInButton();
    }

    @When("Click [Settings] on ProductBar")
    public void clickSettingsOnProductBar() {
        productBarForm.clickSettingsButton();
    }

    @Then("Check that [Log In] form is opened")
    public void checkIfLogInFormIsVisible() {
        baseTest.checkIfLogInFormIsVisible();
    }

    @Then("Check that [Settings] form is opened")
    public void checkThatSettingsFormIsVisible() {
        baseTest.checkThatSettingsFormIsVisible();
    }
}
