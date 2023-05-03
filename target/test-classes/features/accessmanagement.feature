@Daria
Feature: Access management scenarios

  Background:
    When I log in as a "admin"
    When I click nav button "Manage Access"

  @IN-15
  Scenario: User should have an option to filter out the users
    Then Verify Filter dropdown field is displayed:
    #Then Verify if following selection for filter are available:
     # | All        |
      #| First Name |
      #| Last Name  |
      #| E-Mail     |
      #| Role       |
      #| Batch      |

  @IN-16
  Scenario: Each user on Manage Access page should have following options:
    When I verify all Action buttons are displayed
    And I click on "Action" button
    Then Verify action button has the following options displayed
      | Edit           |
      | Delete         |
      | Reset Password |

  @IN-17
  Scenario: "Show all" button display all users from the filtered view
    When I click on "Show all" button
    Then Verify all lines users are displayed