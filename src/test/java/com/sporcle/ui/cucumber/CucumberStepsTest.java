package com.sporcle.ui.cucumber;

import com.sporcle.ui.BaseTest;
import com.sporcle.ui.forms.ProductBarForm;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CucumberStepsTest {
    private final BaseTest baseTest = new BaseTest();
    private ProductBarForm productBarForm;

    @Given("Open ProductBar form")
    public void openProductBarForm() {
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
    public void checkThatLogInFormIsVisible() {
        baseTest.checkThatLogInFormIsVisible();
    }

    @Then("Check that [Settings] form is opened")
    public void checkThatSettingsFormIsVisible() {
        baseTest.checkThatSettingsFormIsVisible();
    }
}
