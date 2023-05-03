@Majid
Feature: login scenarios

  @IN-1
  Scenario: title of the page should be Interview App
    When I log in as a "user"
    Then Verify page title is displayed as "Interview App"


  @IN-10 @IN-11 @IN-12 @IN-12b
  Scenario Outline: when userType logs in btnName button should be visible
    When I log in as a "<userType>"
    Then Verify "<btnName>" button is visible
    Examples:
      | userType | btnName       |
      | Admin    | Manage Access |
      | Admin    | edit/delete   |
      | Admin    | Add Dashboard |
      | User     | Selenium      |


  @IN-13
  Scenario: Admin should see a form in manage access page with following fields
    When I log in as a "Admin"
    And I click on "Manage Access" button
    Then Verify following input fields are displayed:
      | First Name |
      | Last Name  |
      | E-mail     |
      | Role       |
      | Batch      |

  @IN-14
  Scenario: Admin should be able to add new user in manage access page
    When I log in as a "Admin"
    And I click on "Manage Access" button
    And I fill out new user form with following data:
      | Firstname | Peter                      |
      | Lastname  | Griffin                    |
      | Email     | PeterGriffin@familyguy.com |
      | Role      | Mentor                     |
      | Batch     | N/A                        |
    And I click on "Add User" button
    Then Verify the new added user is displayed




