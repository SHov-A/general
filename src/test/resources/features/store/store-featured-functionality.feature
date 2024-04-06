@all @stat_store @featured_left
Feature: Store - Store featured functionality

  Scenario: This scenario login to application with active user, go to store section,
  buy left feature and after that check left count
    Given I am in Initial Page
    And In Initial Page - I should see "STAR TREK Fleet Command" title
    Then In Initial Page - I click on login button
    And In Login Page - I fill "StarTrekWebPortal10@gmail.com" as username
    And In Login Page - I fill "Stwpdev1" as password
    And In Login Page - I click on submit button
    And In Home Page - I should see "NewStar" entered username
    And In Home Page Left Panel - I click on store item
    And In Store Page Featured Section - I click on load more feature button
    And In Store Page Featured Section - I get left text that feature which must buy
    And In Store Page Featured Section - I buy feature
    And In Store Page Opened Popup For Payment - I navigate to popup
    And In Store Page Opened Popup For Payment - I should see "NewStar" username
    And In Store Page Opened Popup For Payment - I click on PayPal button
    And In Store Page Opened Popup For Payment - I click on Pay Now button
    And In Store Page Opened Popup For Payment - I should see "Payment completed. Thank you for your purchase!" title
    And In Store Page Opened Popup For Payment - I click on close button
    And In Store Page Opened Popup For Successful Payment - I should see "Payment successful..." text
    And In Store Page Opened Popup For Successful Payment - I click on close button

# compare
    And In Store Page Featured Section - I check bundle left count after bought