@all @stat_login @validation
Feature: Login - Login with wrong username/password

  Scenario Outline: This scenario login with wrong username/password and check validations
    Given I am in Initial Page
    And In Initial Page - I should see "STAR TREK Fleet Command" title
    Then In Initial Page - I click on login button
    And In Login Page - I fill "<username>" as username
    And In Login Page - I fill "<password>" as password
    And In Login Page - I click on submit button
    And The failure message for wrong username or password should be
    """
    <message>
    """

    Examples:
      | username                       | password | message           |
      | StarTrekWebPortal111@gmail.com | Stwpdev1 | Unable to sign in |
      | StarTrekWebPortal1@gmail.com   | Stwpdev  | Unable to sign in |
      | StarTrekWebPortal121@gmail.com | Stwpdev  | Unable to sign in |

  Scenario Outline: This scenario login with empty password and check validations
    Given I am in Initial Page
    And In Initial Page - I should see "STAR TREK Fleet Command" title
    Then In Initial Page - I click on login button
    And In Login Page - I fill "<username>" as username
    And In Login Page - I fill "<password>" as password
    And In Login Page - I click on submit button
    And The failure message for empty password should be
    """
    <message>
    """

    Examples:
      | username                     | password | message                 |
      | StarTrekWebPortal1@gmail.com |          | Please enter a password |

  Scenario Outline: This scenario login with empty username and check validations
    Given I am in Initial Page
    And In Initial Page - I should see "STAR TREK Fleet Command" title
    Then In Initial Page - I click on login button
    And In Login Page - I fill "<username>" as username
    And In Login Page - I fill "<password>" as password
    And In Login Page - I click on submit button
    And The failure message for empty username should be
    """
    <message>
    """

    Examples:
      | username | password | message                 |
      |          | Stwpdev1 | Please enter a username |

  Scenario Outline: This scenario login with empty username and empty password, check validations
    Given I am in Initial Page
    And In Initial Page - I should see "STAR TREK Fleet Command" title
    Then In Initial Page - I click on login button
    And In Login Page - I fill "<username>" as username
    And In Login Page - I fill "<password>" as password
    And In Login Page - I click on submit button
    And The failure message for empty username and empty password should be
    """
    <message>
    """

    Examples:
      | username | password | message                                         |
      |          |          | Please enter a username/Please enter a password |