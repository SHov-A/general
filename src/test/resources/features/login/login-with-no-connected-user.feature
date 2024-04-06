@all @stat_login @no_connected_user
Feature: Login - Login functionality for no connected user

  Scenario: This scenario login to application with no connected user, click on linking guide button and
  in new opened window check the content text
    Given I am in Initial Page
    And In Initial Page - I should see "STAR TREK Fleet Command" title
    Then In Initial Page - I click on login button
    And In Login Page - I fill "StarTrekWebPortal1@gmail.com" as username
    And In Login Page - I fill "Stwpdev1" as password
    And In Login Page - I click on submit button
    And In Initial Page Opened Popup For No Connected User - I should see "No Connected Account" text
    And In Initial Page Opened Popup For No Connected User - I click on account linking guide button
    And I am in new opened 2 window
    And In New Window Initial Page - I should see "INTRODUCING A NEW WAY TO LOGIN" text