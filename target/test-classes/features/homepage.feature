@home
Feature: Homepage Scenarios

  @AS-3
  Scenario: Verify our address and phone number under the main navigation bar on top of the page is displayed.
    Then the following should be displayed:
    |address1|10090 Main Street|
    |address2|Fairfax, VA, USA|
    |phoneNumber|+1 703-831-3227|

  @AS-5
  Scenario: Verify title of the homepage should be "Advance Systems - Home"
    Then verify title of the homepage is "Advance Systems - Home"

