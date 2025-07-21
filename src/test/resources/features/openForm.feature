Feature: Test open form

  Scenario: Open Log In form
    Given Open ProductBar form
    When Click [Sign In] on ProductBar
    Then Check that [Log In] form is opened

  Scenario: Open Settings form
    Given Open ProductBar form
    When Click [Settings] on ProductBar
    Then Check that [Settings] form is opened