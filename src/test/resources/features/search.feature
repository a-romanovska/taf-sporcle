Feature: Test search

  Scenario: Search one word
    When Input "Banana" into Search bar
    Then Check search results

  Scenario: Search two words with space
    When Input "winter winner" into Search bar
    Then Check search results

  Scenario: Search more than two words
    When Input "Pic winner 30" into Search bar
    Then Check search results

  Scenario: Search empty word
    When Input "" into Search bar
    Then Check search results

  Scenario: Search word with space before and after
    When Input " apple " into Search bar
    Then Check search results

  Scenario: Search space word
    When Input " " into Search bar
    Then Check search results

  Scenario: Search non-existent word
    When Input "jufytftfyt" into Search bar
    Then Check 'No quizzes found' message
