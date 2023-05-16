@studentInfo @api
Feature: perform a request for verifying student info

  Background: Get key to use in any other request

  @AS-24
  Scenario: Update an existing student by ID
    Given I perform a POST request to create new student info with following fields
      | firstName | John         |
      | lastName  | Doe          |
      | batch     | 0            |
      | email     | api@test.com |
    When I perform a PUT request using id parameter to update the following fields
      | batch | 777            |
      | email | Johny@test.com |
    Then verify the update should be successful with status code 200
    When I send a GET request
    Then verify the response body contains the following fields
      | 777            |
      | Johny@test.com |


  @AS-25
  Scenario: Delete an existing student by ID
    Given I perform a post request to create new student info with following fields
      | firstName | John        |
      | lastName  | Doe         |
      | batch     | 0           |
      | email     | api@test.com|
    When I perform a DELETE request using student id parameter
    Then verify the DELETE should be successfully with status code 200
