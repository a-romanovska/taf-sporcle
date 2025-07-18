package com.sporcle.cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class MySteps {
    @Given("Print Hello")
    public void printHello() {
        System.out.println("Hello");
    }

    @When("View Hello")
    public void viewHello() {
        System.out.println("View Hello");
    }

    @Then("Assert Hello")
    public void assertHello() {
        Assertions.assertEquals("Hello", "Java");
    }
}
