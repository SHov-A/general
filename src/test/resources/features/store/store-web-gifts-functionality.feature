@all @stat_store @web_gifts_left
Feature: Store - Store web gifts functionality

  Scenario: This scenario login to application with active user, get sessionID from cookie,
  claim web gift by API call and after that check status code
    Given I am in Initial Page
    And In Initial Page - I should see "STAR TREK Fleet Command" title
    Then In Initial Page - I click on login button
    And In Login Page - I fill "StarTrekWebPortal16@gmail.com" as username
    And In Login Page - I fill "Stwpdev1" as password
    And In Login Page - I click on submit button
    And In Home Page - I should see "Officer Lom5013434" entered username
    And I get "sessionID" from cookie and do HttpGetRequest to get web gifts response body
    And I get "sessionID" from cookie, do HttpPostRequest to claim web gift and response status code should be 200