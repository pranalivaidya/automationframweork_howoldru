#Author: Pranali H Vaidya
Feature: How old are you home page

  Background: 
    Given user navigate to home page

  @TC0
  Scenario: Home page title
    Then I validate the page title
      | How old are you? |

  @TC1
  Scenario: Home page header text
    Then I validate the header text
      | How old are you? |

  @TC2
  Scenario: Default fields - your name and your birthday
    Then I verify yourName is by default empty
    And your birthday field is by default empty

  @TC3
  Scenario Outline: Invalid field - your name
    When user keeps your name as blank <yourName>
    And user enters correct your birthday field as <yourBirthday>
    And user clicks on submit button
    Then user verify error <error> for name field

    Examples: 
      | yourName | yourBirthday | error               |
      | ""       | "07/08/1994" | "incorrect symbols" |

  @TC4
  Scenario Outline: Birthday year is less than 1900
    When user enters correct your name field as <yourName>
    And user enters correct your birthday field as <yourBirthday>
    And user clicks on submit button
    Then user verify error <error> for birthday field

    Examples: 
      | yourName | yourBirthday | error                       |
      | pranali  | "15/04/19"   | "you are too old to use it" |

  @TC5
  Scenario Outline: Your birthday field is blank
    Given user navigate to home page
    When user enters correct your name field as <yourName>
    And user enters correct your birthday field as <yourBirthday>
    And user clicks on submit button
    Then user verify error <error> for birthday field

    Examples: 
      | yourName | yourBirthday | error        |
      | pranali  | ""           | "wrong date" |

  @TC6
  Scenario Outline: Find your ege
    When user enters correct your name field as <yourName>
    And user enters correct your birthday field as <yourBirthday>
    And user clicks on submit button
    Then user verify age is displayed as <yourBirthday>
    And user verify hello text is displayed <yourName>

    Examples: 
      | yourName | yourBirthday |
      | pranali  | "15/04/1994" |
