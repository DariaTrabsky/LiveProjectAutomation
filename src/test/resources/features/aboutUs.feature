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
    When I click on "our services" button
    Then verify title of the services page is "Advance Systems - Services"

