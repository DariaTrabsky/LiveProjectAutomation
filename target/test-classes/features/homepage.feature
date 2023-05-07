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

  @AS-11
  Scenario: Display Testimonials Section
    Then Verify the testimonials header is "Words from our Clients"
    And Verify there are multiple testimonials messages under Testimonials Section
    And Verify there are people names and states under Testimonials Section


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

  @AS-15
  Scenario: Verify social media buttons displayed in the footer section
    Then verify the social media buttons are displayed:
      | Facebook |
      | Twitter  |
      | Instagram|
      | LinkedIn |

  @AS-16
  Scenario: Verify email input field with a place holder is displayed in Newsletter section
    Then verify email input field with a place holder is displayed
