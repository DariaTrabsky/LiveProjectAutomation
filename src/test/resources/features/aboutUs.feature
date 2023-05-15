@aboutUs
Feature: About Us Scenarios

  Background: Navigate to About Us page
    Given I click on "ABOUT US" button

  @AS-29
  Scenario: Verify Why Choose Us section has 3 headers and their descriptions
    When Why Choose Us section loads
    Then this section should display the following headers with their descriptions:
      | On Time Services   | Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry.              |
      | Experienced Team   | Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard.   |
      | Good Track Records | Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's dummy text. |

  @AS-31
 Scenario:Verify under header text “We are Recruitment Experts” the button Our Services takes user to Services page
    And We are Recruitment Experts text is displayed on the page
   When I click on {string} button
    Then verify title of the services page is "Advance Systems - Services"

  @AS-28
  Scenario: There should be a main header “Welcome to Advance Systems LLC.”
    Then verify main header is "Welcome to Advance Systems LLC."
    Then verify this section should contain name and title of the person.

  @AS-30
  Scenario: This section should have a header “Meet Our Experts”.
    Then verify employee header is "Meet Our Experts"
    And verify the following information is displayed:
      | picture            |
      | title              |
      | quote              |
      | social media links |
      | Facebook           |
      | twitter            |
      | Skype              |
      | Linkedin           |

  @AS-32
  Scenario: This section should have 4 headers with description texts.
    Then verify following headers with descriptions are displayed:


