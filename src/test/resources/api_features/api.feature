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

  @AS-20
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

  @AS-22
  Scenario: Deleting existing Dev course from db
    Given the "Dev" course endpoint is "https://tla-school-api.herokuapp.com/api/school/programs/devcourse"
    Given  I send a POST request to the course endpoint with following fields
      | duration | 1000 days      |
      | name     | Dev new Course |
    When I perform a DELETE request using course name parameter
    Then the delete should be successful with status code 200

  @AS-22
  Scenario: Deleting existing SDET course from db
    Given the "SDET" course endpoint is "https://tla-school-api.herokuapp.com/api/school/programs/sdetcourse"
    Given  I send a POST request to the course endpoint with following fields
      | duration | 1000 days       |
      | name     | SDET new Course |
    When I perform a DELETE request using course name parameter
    Then the delete should be successful with status code 200

  @AS-26
  Scenario: User requests a bearer token with valid credentials
    Given the API endpoint is "https://tla-school-api.herokuapp.com/api/school/departments/gettoken"
    And a get request is made with valid username "user" and password "user123"
    Then the response body should contain token
    And the response status code is 200

  @AS-26
  Scenario Outline: Error message should be returned in case credentials are invalid.
    Given the API endpoint is "https://tla-school-api.herokuapp.com/api/school/departments/gettoken"
    And a get request is made with following invalid "<username>" and "<password>":
    And the response body contains the error message "Valid username and password required"
    And the response status code is 401
    Examples:
      | username | password |
      | user     | user$123 |
      | 124      | @#@      |
      | $#@      | user     |
      | u        | 124      |

  @AS-21
  Scenario: Add a new course to the database
    Given the "Dev" course endpoint is "https://tla-school-api.herokuapp.com/api/school/programs/devcourse"
    When I send a POST request to the Dev course endpoint to add the course
    Then the response status code is 200
    And the response body contains the following fields:
      | id       |
      | name     |
      | duration |

  @AS-21
  Scenario: Add a new course to the database
    Given the "SDET" course endpoint is "https://tla-school-api.herokuapp.com/api/school/programs/sdetcourse"
    When I send a POST request to the SDET course endpoint to add the course
    Then the response status code is 200
    And the response body contains the following fields:
      | id       |
      | name     |
      | duration |





