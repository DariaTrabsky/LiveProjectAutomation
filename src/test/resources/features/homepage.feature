@home
Feature: Homepage Scenarios

  @AS-3 @majid
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


  @AS-8
  Scenario Outline: Verify each button goes to corresponding url
    When I scroll down the page
    And I click on secondary navigation bar button "<button>"
    Then Verify corresponding window has url as "<URL>"
    Examples:
      | button     | URL                                                               |
      | Home       | https://tla-batch7.github.io/advancesystems-test-b7/index.html    |
      | About Us   | https://tla-batch7.github.io/advancesystems-test-b7/about.html    |
      | Services   | https://tla-batch7.github.io/advancesystems-test-b7/services.html |
      | Clients    | https://tla-batch7.github.io/advancesystems-test-b7/clients.html  |
      | Join Us    | https://tla-batch7.github.io/advancesystems-test-b7/joinUs.html   |
      | Contact Us | https://tla-batch7.github.io/advancesystems-test-b7/contact.html  |


  @AS-12
  Scenario: Verify list of companies above the footer is displayed
    Then verify list of companies is displayed

  @AS-15
  Scenario Outline: Verify social media buttons displayed in the footer section
    Then verify "<social_media>" footer buttons are displayed on the main page
    And verify when media footer button is clicked user gets redirected to the "<url>" page
    Examples:
      | social_media | url                        |
      | facebook     | https://www.facebook.com/  |
      | twitter      | https://twitter.com/       |
      | instagram    | https://www.instagram.com/ |
      | linkedin     | https://www.linkedin.com/  |

  @AS-11 @majid
  Scenario: Display Testimonials Section
    Then Verify the testimonials header is "Words from our Clients"
    And Verify there are multiple testimonials messages under Testimonials Section
    And Verify there are people names and states under Testimonials Section

  @AS-17 @majid
  Scenario: Move to top button
    When I scroll down to the bottom of the page
    Then Verify There should be a button in the bottom right corner of the page
    And Verify the button would scroll the window to top content once clicked

  @AS-16
  Scenario: Verify email input field with a place holder is displayed in Newsletter section
    Then verify email input field with a place holder is displayed
    Then verify the text of the place holder is "Email Address..."

  @AS-14
  Scenario Outline: Verify footer links are displayed and button goes to corresponding URL
    Then verify footer "<links>" buttons are displayed
    Then verify that when links are clicked, corresponding window has "<url>"
    Examples:
      | links      | url                                                               |
      | Home       | https://tla-batch7.github.io/advancesystems-test-b7/index.html    |
      | About Us   | https://tla-batch7.github.io/advancesystems-test-b7/about.html    |
      | Services   | https://tla-batch7.github.io/advancesystems-test-b7/services.html |
      | Clients    | https://tla-batch7.github.io/advancesystems-test-b7/clients.html  |
      | Join Us    | https://tla-batch7.github.io/advancesystems-test-b7/joinUs.html   |
      | Contact Us | https://tla-batch7.github.io/advancesystems-test-b7/contact.html  |

  @AS-13
  Scenario: Verify contact information is displayed
    Then verify the following contact information is displayed:
      | Address            |
      | Phone              |
      | Email              |
      | Hours Of Operation |

  @AS-18
  Scenario: Copyright update
   Then verify copyright text should be updated with "Copyright © 2023 Advance Systems LLC. All Rights Reserved."

  @AS-19
  Scenario: Verify main header section
    Then verify main header section is "Welcome to Advance Systems LLC."
    Then verify secondary header is "Our Mission is simple, deliver very honest recruitment services to every customer."
    Then verify description text is displayed

  @AS-10
  Scenario: Verify section with 5 items and their descriptions
    When the section with services loads
    Then the section with services should display the following items with their descriptions:
      | Leadership Development        | Lorem Ipsum is simply dummy text of the printing and typesetting industry. |
      | Capability Building           | Lorem Ipsum is simply dummy text of the printing and typesetting industry. |
      | Rewards & Benefits            | Lorem Ipsum is simply dummy text of the printing and typesetting industry. |
      | Employee & Employer Relations | Lorem Ipsum is simply dummy text of the printing and typesetting industry. |
      | Excellent Customer Service    | Lorem Ipsum is simply dummy text of the printing and typesetting industry. |


  @AS-4
  Scenario: There should be a section under navigation bar with Header, description and Read More button.
    Then verify read more button is displayed and takes user to the services page
    Then verify header is displayed
    Then verify description is displayed
    Then verify Section content should refresh with new set of header and description



