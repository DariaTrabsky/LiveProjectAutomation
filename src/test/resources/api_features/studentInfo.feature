@studentInfo @api
Feature: perform a request for verifying student info

  Background: Get key to use in any other request

  @AS-24
  Scenario: Update an existing student by ID
    Given I perform a POST request to create new student info with following fields
          |firstName|John|
          |lastName|Doe|
          |batch   |0  |
          |email   |api@test.com|
    When I perform a PUT request using id parameter to update the following fields
      |batch   |7  |
      |email   |Johny@test.com|
    When I perform a PUT request using id parameter to update the following fields
      |batch   |7  |
      |email   |Johny@test.com|
    Then verify the update should be successful with status code 200

