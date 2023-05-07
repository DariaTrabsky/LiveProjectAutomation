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


  @AS-8
  Scenario Outline: Verify each button goes to corresponding url
    When I scroll down the page
    And I click on secondary navigation bar button "<button>"
    Then Verify corresponding window has url as "<URL>"
    Examples:
      | button            | URL                                                                                 |
      | Home              | https://tla-batch7.github.io/advancesystems-test-b7/index.html                      |
      | About Us          | https://tla-batch7.github.io/advancesystems-test-b7/about.html                      |
      | Services          | https://tla-batch7.github.io/advancesystems-test-b7/services.html                   |
      | Clients           | https://tla-batch7.github.io/advancesystems-test-b7/clients.html                    |
      | Join Us           | https://tla-batch7.github.io/advancesystems-test-b7/joinUs.html                     |
      | Contact Us        | https://tla-batch7.github.io/advancesystems-test-b7/contact.html                    |




