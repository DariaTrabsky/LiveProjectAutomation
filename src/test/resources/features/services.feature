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
