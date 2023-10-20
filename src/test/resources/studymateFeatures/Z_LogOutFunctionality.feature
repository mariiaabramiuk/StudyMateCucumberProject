@LogoutTest
Feature: User Logout

  Scenario: Verify Confirmation Message Before Logout
    When the user clicks on Administrator button in the user profile
    Then the user clicks on the Logout button in the user profile
    Then the user should see a confirmation message Do you really want to log out?

  Scenario: Verify Logout Cancel Button
    When the user presses the cancel button
    Then the user should stay on the current web application page

  Scenario: Verify Normal Logout
     And the user clicks on the Logout button in the user profile
    Then the user should confirm logout
    And the system should redirect the user to the login page
