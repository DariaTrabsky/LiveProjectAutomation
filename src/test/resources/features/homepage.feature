@Raven
Feature: Homepage Scenarios
  Background:
    When I log in as a "user"

  @IN-3
  Scenario Outline: Verify Dashboard buttons are displayed
    Then Verify "<button name>" is displayed
    Examples:
    |button name|
    |All Topics |
    |Soft Skills|
    |Coding     |

  @IN-4a
  Scenario: User should be able to add to do's section
    When I click on "Add do" button
    Then I click on "input area 1" text box
    And I will type "Do study hard"
    When I click on "Enter 1" button
    Then Verify "Do study hard" is displayed

  @IN-4b
  Scenario: User should be able to add to don't section
    When I click on "Add don't" button
    Then I click on "input area 2" text box
    And I will type "Don't be a hater"
    When I click on "Enter 1" button
    Then Verify "Don't be a hater" is displayed

  @IN-5a
  Scenario: User should be able to ask a question
    When I click on "Soft Skills" button
    Then I click on "Enter new question" button
    When I click on "Soft Skills question" text box
    And I will type "Who's going to win the NBA Championship?"
    Then I click on "Enter 3" button
    Then Verify "Who's going to win the NBA Championship?" is displayed


  @IN-5b
  Scenario: User should be able to ask a question
    When I click on "Coding" button
    Then I click on "Enter new question" button
    When I click on "Coding Question Box" text box
    And I will type "Who's going to win the NCAA Championship?"
    Then I click on "Enter 3" button
    Then Verify "Who's going to win the NCAA Championship?" is displayed

  @IN-6a
  Scenario: User should be able to edit or delete question
    When I click on "Soft Skills" button
    Then Verify "Edit" button is enabled
    Then Verify "Delete" button is enabled
    
  @IN-6b
    Scenario: User should be able to edit or delete question
    When I click on "Coding" button
    Then Verify "Edit" button is enabled
    Then Verify "Delete" button is enabled

  @IN-7
  Scenario: User questions should be displayed in "All Topics"
    When I click on "All Topics" button
    Then Verify "Who's going to win the NCAA Championship?" is displayed
    Then Verify "Who's going to win the NBA Championship?" is displayed
