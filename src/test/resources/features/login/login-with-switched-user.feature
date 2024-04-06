@all @stat_login @switched_user
Feature: Login - Login logout functionality for switched user

  Scenario Outline: This scenario login to application with switched users, and username must be same.
    Given I am in Initial Page
    And In Initial Page - I should see "STAR TREK Fleet Command" title
    Then In Initial Page - I click on login button
    And In Login Page - I fill "<username>" as username
    And In Login Page - I fill "<password>" as password
    And In Login Page - I click on submit button
    And In Home Page - I should see "<message>" entered username
    And In Home Page - I click on entered username
    And In Home Page - I click on logout button
    And In Initial Page After Logout - I should see null "sessionID"

    Examples:
      | username                      | password | message |
      | StarTrekWebPortal9@gmail.com  | Stwpdev1 | NewStar |
      | StarTrekWebPortal10@gmail.com | Stwpdev1 | NewStar |