@all @stat_login @normal_user
  Feature: Login - Login logout functionality for normal user

    Scenario: This scenario login to application with normal user, check username and log out from application
      Given I am in Initial Page
      And In Initial Page - I should see "STAR TREK Fleet Command" title
      Then In Initial Page - I click on login button
      And In Login Page - I fill "Colm.gallagher+6@scopely.com" as username
      And In Login Page - I fill "CowSpoon6Gate" as password
      And In Login Page - I click on submit button
      And In Home Page - I should see "Officer Tsc9682674" entered username
      And In Home Page - I click on entered username
      And In Home Page - I click on logout button
      And In Initial Page After Logout - I should see null "sessionID"