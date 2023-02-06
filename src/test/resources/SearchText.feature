Feature: Search for something using the Google engine

  Scenario Outline: Enter text and search using return key
    Given On the google engine base page
    When I enter <text> and press return
    Then Search page is loaded with text in search box

    Examples:
    | text |
    | sample text |
    | sample text 2 |
