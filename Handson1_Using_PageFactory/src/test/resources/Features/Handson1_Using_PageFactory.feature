
@TestToRun
Feature: Check google search functionality

  Scenario Outline: Validate google search is working
    Given Browser is open  User is on google search page
    When User enter a <text> in google search box
    And User Clicks enter button
    Then User is navigated to the search result page
    And Gets the number of links available

    Examples: Input
      | text               |
      | Cucumber framework |
      
  