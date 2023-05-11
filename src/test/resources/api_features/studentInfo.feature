@studentInfo
Feature: perform a request for verifying student info

  Background: Get key to use in any other request

  @AS-24
  Scenario: Update an existing student by ID
    Given I perform a POST request to "https://tla-school-api.herokuapp.com/api/school/resources/students" to create new student info
    And I retrieve student id
    When To Update an existing, I perform a PUT request to "https://tla-school-api.herokuapp.com/api/school/resources/students" using id parameter
    Then the update should be successful with status code 200
    Then verify the response contains the following fields
      | email | Jonh@api.com |
      | batch | 1000         |
