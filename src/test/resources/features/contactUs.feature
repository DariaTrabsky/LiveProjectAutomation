@contractUs
Feature: Contact Us Scenarios
  Background: Navigate to Contact Us page
    Given I click on "CONTACT US" button

  @AS-37
  Scenario: Verify form to contact
    Then verify the following input fields are displayed
      | Name                            |
      | Phone number                    |
      | Option to choose a service type |
      | Box to enter a message          |
      | Button to send the request      |