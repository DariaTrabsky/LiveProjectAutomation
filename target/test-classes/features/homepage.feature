@home
Feature: Homepage Scenarios

  @AS-3
  Scenario: Verify our address and phone number under the main navigation bar on top of the page is displayed.
    Then the following should be displayed:
      | address1    | 10090 Main Street |
      | address2    | Fairfax, VA, USA  |
      | phoneNumber | +1 703-831-3217   |

  @AS-5
  Scenario: Verify title of the homepage should be "Advance Systems - Home"
    Then verify title of the homepage is "Advance Systems - Home"

  @AS-6
  Scenario: Verify navigation bar buttons and language dropdown are displayed
    Given verify title of the homepage is "Advance Systems - Home"
    When I look at the navigation bar
    Then verify the following nav button are displayed:
      | Get Support |
      | Job Career  |
      | Feedback    |
      | English     |
      | Spanish     |
      | French      |


  @AS-9
  Scenario Outline: Verify social media buttons redirect to correct URL
    Given verify title of the homepage is "Advance Systems - Home"
    And verify "<social_media>" buttons are displayed on the main page
    Then verify when media button is clicked user gets redirected to the "<url>" page
    Examples:
      | social_media | url                        |
      | facebook     | https://www.facebook.com/  |
      | twitter      | https://twitter.com/       |
      | instagram    | https://www.instagram.com/ |
      | linkedin     | https://www.linkedin.com/  |
