@joinUs
Feature: Join Us Scenarios

  @AS-7
  Scenario: Verify Join now button is able to take user to "Join Us" page.
    When I click on "Join now" button
    Then verify page-info "Join Us" is display

