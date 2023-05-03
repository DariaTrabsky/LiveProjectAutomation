@DariaHome
Feature: HomePage scenarios

  Background:
    When I log in as a "user"

  @IN-2
  Scenario: Verify when user logged in under his credentials "Sign out" button is displayed
    When user is on the main page
    Then Verify "Sign out" button is displayed
    And Verify "Manage access" button is not displayed
