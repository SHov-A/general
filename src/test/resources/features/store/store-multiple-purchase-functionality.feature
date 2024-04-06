@all @stat_store @multiple_purchase
Feature: Store - Store multiple purchase functionality

  Scenario: This scenario login to application with active user, go to store section
  and check multiple purchase functionality
    Given I am in Initial Page
    And In Initial Page - I should see "STAR TREK Fleet Command" title
    Then In Initial Page - I click on login button
    And In Login Page - I fill "StarTrekWebPortal10@gmail.com" as username
    And In Login Page - I fill "Stwpdev1" as password
    And In Login Page - I click on submit button
    And In Home Page - I should see "NewStar" entered username
    And In Home Page Left Panel - I click on store item
    And In Store Page Featured Section - I click on load more feature button
    And In Store Page Featured Section - I select multiple purchase feature
    And In Store Page Basket Section - I should see purchase "" count
    And In Store Page Featured Section - I click on basket
    And In Store Page Basket Section - I check that minus button is "disabled"
    And In Store Page Basket Section - I put "0" count
    And In Store Page Basket Section - I should see "The minimum available quantity is 1" text
    And In Store Page Basket Section - I put "20" count
    And In Store Page Basket Section - I check that plus button is "disabled"
    And In Store Page Basket Section - I put "21" count
    And In Store Page Basket Section - I should see "20" count
    And In Store Page Basket Section - I should see "Number exceeds available quantity" text
    And In Store Page Basket Section - I put random count
    And In Store Page Basket Section - I should see purchase random count
    And In Store Page Bundle Section - I should see random updated price
    And In Store Page Featured Section - I buy bundle feature
    And In Store Page Opened Popup For Payment - I navigate to popup
    And In Store Page Opened Popup For Payment - I click on PayPal button
    And In Store Page Opened Popup For Payment - I check total price