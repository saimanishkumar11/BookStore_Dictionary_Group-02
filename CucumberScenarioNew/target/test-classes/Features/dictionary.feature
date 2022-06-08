@dictionaryfunctionality
Feature: Functionality of Dictionary application

  @logo
  Scenario: Successful logo
    Given User navigates to "https://dictionary.cambridge.org"
    When user finds the logo
    Then user validate the logo

  @word
  Scenario: User learns new word from word of the year
    Given user is in home page
    When user scrolls
    And user clicks on word of the year
    Then user finds word of the year

  @meaning
  Scenario Outline: user use dictionay to get meaning of the words
    Given user is in home page
    Then user enters <word> to get meaning

    Examples: 
      | word       |
      | AVALANCHE  |
      | HYSTERICAL |
      | TURNCOAT   |

  @listen
  Scenario: user listens to British English Pronounciation
    Given user is in home page
    Then user seacrh for word to listen in British English Pronounciation
      | SOUS VIDE |
    
    
  @facebookpage
  Scenario: user looks for cambridge dictionary facebook page
    Given: user is in home page

    When user clicks on facebook logo
    Then user navigate to cambridge dictionary facebook page

  @invalidsearch
  Scenario: user search for invalid words
    Given user is in home page
    When user enters invalid words error message is displayed
