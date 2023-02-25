Feature: Search for something using the Google engine

  Scenario Outline: Enter text and search using return key
    Given On the google engine base page
    When I enter <text> and press return
    Then All Search page is loaded with <text> in search box

    Examples:
      | text            |
      | "sample text"   |
      | "sample text 2" |

  Scenario Outline: Enter text and search using Google Search button
    Given On the google engine base page
    When I enter <text> and click on the Google Search button
    Then All Search page is loaded with <text> in search box
    Examples:
      | text            |
      | "sample text"   |
      | "sample text 2" |

    Scenario: Search for text, then select images
      Given On the google engine base page
      When I enter "qualitest" and click on the Google Search button
      And I click on the images button
      Then Image Search page is loaded with "qualitest" in search box