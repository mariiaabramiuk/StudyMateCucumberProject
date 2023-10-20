@LoginTest
Feature: User Login

  Background:
    Given the user is on the login page

  Scenario: Verify that a user receives a message for a short password
    When the user enters a valid username
    And  the user enters a shorter then six characters password
    Then the user clicks the Login button
    Then the user should see the message Password must be at least 6 characters
    Then the username field will get cleared
    And  the password field will get cleared

  Scenario: Verify the system displays an error message for an invalid username
    When the user enters an invalid username
    And the user enters a valid password
    Then the user clicks the Login button
    Then the system should display an error message for an invalid username
    Then the username field will get cleared
    And  the password field will get cleared

  Scenario: Verify the system displays an error message for an invalid password
    When the user enters a valid username
    And the user enters an invalid password
    Then the user clicks the Login button
    Then the system should display an error message for an invalid password
    Then the username field will get cleared
    And  the password field will get cleared

  Scenario: Verify the system handles an empty username field
    When the user enters a valid password and leaves the username field empty
    Then the user clicks the Login button
    Then the system should display an error message for an empty username field
    And  the password field will get cleared

  Scenario: Verify the system handles an empty password field
    When the user enters a valid username and leaves the password field empty
    Then the user clicks the Login button
    Then the system should display an error message for an empty password field
    Then the username field will get cleared

  Scenario: Verify Show Password Button
    When the user enters a valid username
    And  the user enters a valid password
    Then the user clicks the reveal password button
    And the password should be revealed

  Scenario: Verify Successful Login with Russian Language
    When the user enters a valid username
    And  the user enters a valid password
    Then the user selects the Russian language from the language dropdown
    And the user clicks the Login button
    Then the user logs in, and the interface is displayed in Russian
    And the user logs out successfully

  Scenario: Verify Error Handling for Incorrect Email Format
    When the user enters an email in an incorrect format
    And  the user enters a valid password
    Then the system should display an error message
    Then the username field will get cleared
    And  the password field will get cleared

  Scenario: Verify that a user can successfully log in with valid credentials
    When the user enters a valid username
    And  the user enters a valid password
    Then the user clicks the Login button
    Then the user should be granted access to their account without any error messages
