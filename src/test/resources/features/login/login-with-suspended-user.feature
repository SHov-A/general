@all @stat_login @suspended_user
Feature: Login - Login functionality for suspended user

  Scenario: This scenario login to application with suspended user and in opened popup check the content text
    Given I am in Initial Page
    And In Initial Page - I should see "STAR TREK Fleet Command" title
    Then In Initial Page - I click on login button
    And In Login Page - I fill "StarTrekWebPortal5@gmail.com" as username
    And In Login Page - I fill "Stwpdev1" as password
    And In Login Page - I click on submit button
    And In Initial Page Opened Popup For Suspended User - I should see "Account Suspended" text