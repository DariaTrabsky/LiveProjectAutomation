@api
Feature: perform a request for verifying course data for SDET and Dev

  @AS-20
  Scenario: Retrieve SDET Course Names
    Given the "SDET" course endpoint is "https://tla-school-api.herokuapp.com/api/school/programs/devcourse"
    When I send a GET request to the SDET course endpoint
    Then the response status code is 200
    And the response body contains the following fields:
      | id       |
      | name     |
      | duration |

  Scenario: Retrieve Devs Course Names
    Given the "Dev" course endpoint is "https://tla-school-api.herokuapp.com/api/school/programs/devcourse"
    When I send a GET request to the SDET course endpoint
    Then the response status code is 200
    And the response body contains the following fields:
      | id       |
      | name     |
      | duration |

  @AS-23
  Scenario: Adding a new student
    Given I have the following student details
      | batch | firstName | lastName | email                   |
      | 7     | John      | Doe      | john.doe@tlastudent.com |
    When I perform a POST request to add the student
    Then the student should be successfully added to the database

  @AS-22a
  Scenario: Deleting existing Dev course from db
    Given I perform a POST request to "Dev" endpoint "https://tla-school-api.herokuapp.com/api/school/programs/devcourse"
    And I retrieve a course name
    When To delete an existing, I perform a DELETE request to "https://tla-school-api.herokuapp.com/api/school/resources/students" using course name parameter
    Then the delete should be successful with status code 200
    Then verify "course name" does not exist in response body

  @AS-22b
  Scenario: Deleting existing SDET course from db
    Given I perform a POST request to "SDET" endpoint "https://tla-school-api.herokuapp.com/api/school/programs/devcourse"
    And I retrieve a course name
    When To delete an existing, I perform a DELETE request to "https://tla-school-api.herokuapp.com/api/school/resources/students" using course name parameter
    Then the delete should be successful with status code 200
    Then verify "course name test" does not exist in response body



