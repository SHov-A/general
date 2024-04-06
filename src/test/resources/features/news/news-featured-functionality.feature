@all @stat_news @news_page
Feature: News page - Buttons functionality

  Background: Navigating to Star Trek news page
    Given I am in Initial Page
    And In Initial Page - I should see "STAR TREK Fleet Command" title
    Then In Initial Page - I click on News section

  Scenario: This scenario checks "Game information" news filtering, click on random news from list
  and check if it's redirect to blog with right URL
    And In News Page - I click on Game information category
    And In News Page - I click on Show More button if its exists
    And In News Page - I get the list of news of category Game information contain "#Game information" text
    And In News Page - I click on any of Game Information hashtag
    And I am in new opened 2 window
    And In New Window - I see Game Information "https://www.startrekfleetcommand.com/category/guides/" URL

  Scenario: This scenario checks "News" news filtering, click on random news from list
  and check if it's redirect to blog with right URL
    And In News Page - I click on News category
    And In News Page - I click on Show More button if its exists
    And In News Page - I get the list of news of category News contain "#News" text
    And In News Page - I click on any of News hashtag
    And I am in new opened 3 window
    And In New Window - I see News "https://www.startrekfleetcommand.com/category/news/" URL

  Scenario: This scenario checks "Community" news filtering, click on random news from list
  and check if it's redirect to blog with right URL
    And In News Page - I click on Community  category
    And In News Page - I click on Show More button if its exists
    And In News Page - I get the list of news of category Community contain "#Community" text
    And In News Page - I click on any of Community hashtag
    And I am in new opened 4 window
    And In New Window - I see Community "https://www.startrekfleetcommand.com/category/community/" URL

  Scenario: This scenario get main news title and compare it with first news title
    And In News Page - I get main news title and compare it with first news title

  Scenario: This scenario try to find Latest In-game News section for logged out user
    And In News Page - I try to find Latest In-game News section

  Scenario: This scenario try to find Latest In-game News section for logged in user and check the functionality of the section
    And In Initial Page - I click on login button
    And In Login Page - I fill "StarTrekWebPortal10@gmail.com" as username
    And In Login Page - I fill "Stwpdev1" as password
    And In Login Page - I click on submit button
    And In Home Page - I should see "NewStar" entered username
    And In News Page - I get the list of In game news and check if the name is equal to main news after clicking


