@all @stat_login @archived_user
  Feature: Login - Login functionality for archived user

    Scenario: This scenario login to application with archived user, click on OK button and
    in initial page check the login button text
      Given I am in Initial Page
      And In Initial Page - I should see "STAR TREK Fleet Command" title
      Then In Initial Page - I click on login button
      And In Login Page - I fill "StarTrekWebPortal4@gmail.com" as username
      And In Login Page - I fill "Stwpdev1" as password
      And In Login Page - I click on submit button
      And In Initial Page Opened Popup For Archived User - I should see "Please Log In" text
      And In Initial Page Opened Popup For Archived User - I click on OK button
      And In Initial Page - I should see "Login via ScopelyID" login button text