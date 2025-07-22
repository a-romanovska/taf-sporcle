Feature: Test open form

  Scenario: Open LogIn
    Given Open ProductBar
    When Click [Sign In] on ProductBar
    Then Check that [Log In] form is opened

  Scenario: Open Settings
    Given Open ProductBar
    When Click [Settings] on ProductBar
    Then Check that [Settings] form is opened
