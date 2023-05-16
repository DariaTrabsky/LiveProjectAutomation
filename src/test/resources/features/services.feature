@services
Feature: Services Scenarios

  Background: Navigate to Services page
    Given I click on "SERVICES" button

  @AS-33
  Scenario Outline: Verify  divisions is displayed
    Then verify "<division>" is displayed
    Then verify division is clicked user gets redirected to the "<pageTitle>" page
    Examples:
      | division               | pageTitle                                      |
      | Finance                | Advance Systems - Finance Division             |
      | Information Technology | Advance Systems - IT Division                  |
      | Healthcare             | Advance Systems - Healthcare Division          |
      | Government Projects    | Advance Systems - Government Projects Division |

  @AS-35
  Scenario Outline: Verify contracts Info
    When I click on "<division>" buttons
    Then Verify the contacts are displayed
    Examples:
      | division               |
      | Finance                |
      | Information Technology |
      | Healthcare             |
      | Government Projects    |


  @AS-34
  Scenario Outline: Verify the mini navigation bar buttons are displayed without going to Services page
    Then I click on "Finance" division button
    When I click on "<division>" navigation button
    Then verify the following  are displayed and go to corresponding "<url>"
    Examples:
    |division | url |
    |Finance  | https://tla-batch7.github.io/advancesystems-test-b7/division-finance.html |
    |Information Technology| https://tla-batch7.github.io/advancesystems-test-b7/division-it.html |
    |Healthcare            | https://tla-batch7.github.io/advancesystems-test-b7/division-healthcare.html |
    |Government Projects   | https://tla-batch7.github.io/advancesystems-test-b7/division-government.html |
    |Others                | https://tla-batch7.github.io/advancesystems-test-b7/division-others.html |


  @AS-36
  Scenario Outline: Verify header, main image, description and quote
    When I click on "<division>" buttons on main page
    Then verify header, main image, description, quote is displayed
    Examples:
    |division|
    |Finance  |
    |Information Technology|
    |Healthcare            |
    |Government Projects |
    |Others |