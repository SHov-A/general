@all @stat_sidebar @left_sidebar
Feature: Left sidebar - Buttons functionality

  Background: Navigating to Star Trek webpage
    Given I am in Initial Page
    And In Initial Page - I should see "STAR TREK Fleet Command" title

  Scenario: This scenario checks the functionality of Facebook button
    Then In Left Sidebar - I click on facebook button
    And I am in new opened 2 window
    And In New Window - I should see  Facebook's "https://www.facebook.com/login/?next=https%3A%2F%2Fwww.facebook.com%2FStarTrekFleetCommand" URL

  Scenario: This scenario checks the functionality of Youtube button
    Then In Left Sidebar - I click on Youtube button
    And I am in new opened 3 window
    And In New Window - I should see Youtube's "https://www.youtube.com/channel/UCaPdLI1d-6LveN5w0kmtroA" URL

  Scenario: This scenario checks the functionality of Twitter button
    Then In Left Sidebar - I click on Twitter button
    And I am in new opened 4 window
    And In New Window - I should see Twitter's "https://twitter.com/StarTrekFleet" URL

  Scenario: This scenario checks the functionality of Instagram button
    Then In Left Sidebar - I click on Instagram button
    And I am in new opened 5 window
    And In New Window - I should see Instagram's "https://www.instagram.com/accounts/login/" URL

  Scenario: This scenario checks the functionality of Discord button
    Then In Left Sidebar - I click on Discord button
    And I am in new opened 6 window
    And In New Window - I should see Discord's "https://discord.com/invite/stfc" URL

  Scenario: This scenario checks the functionality of Terms of Service button
    Then In Left Sidebar - I click on Terms of Service button
    And I am in new opened 7 window
    And In New Window - I should see Terms of Service's "https://scopely.com/tos/" URL

  Scenario: This scenario checks the functionality of Privacy Policy button
    Then In Left Sidebar - I click on Privacy Policy button
    And I am in new opened 8 window
    And In New Window - I should see Privacy Policy's "https://scopely.com/privacy/" URL

  Scenario: This scenario checks the functionality of AppStore button
    Then In Left Sidebar - I click on AppStore button
    And I am in new opened 9 window
    And In New Window - I should see AppStore's "https://apps.apple.com/us/app/star-trek-fleet-command/id1427744264" URL

  Scenario: This scenario checks the functionality of GooglePlay button
    Then In Left Sidebar - I click on GooglePlay button
    And I am in new opened 10 window
    And In New Window - I should see GooglePlay's "https://play.google.com/store/apps/details?id=com.scopely.startrek&gl=ES" URL

  Scenario: This scenario checks Copyright Title and Text
    Then In Left Sidebar - I get CopyrightTitle "© 2021 SCOPELY"
    Then In Left Sidebar - I get CopyrightText "TM & © CBS Studios Inc. © 2021 Paramount Pictures Corp. STAR TREK and related marks and logos are trademarks of CBS Studios Inc. All Rights Reserved"

  Scenario: This scenario checks the functionality of Home button
    Then In Left Sidebar - I click on Home page button
    And In Page - I see "GO TO STORE" button

  Scenario: This scenario checks the functionality of Store button
    Then In Left Sidebar - I click on Store page button
    And In Page - I see pop up "Login With Your Scopely ID to Visit the Store"

  Scenario: This scenario checks the functionality of News button
    Then In Left Sidebar - I click on News page button
    And In Page - I see "https://storedev.startrekfleetcommand.com/news" URL