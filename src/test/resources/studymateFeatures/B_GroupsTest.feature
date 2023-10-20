@FeatureTest
Feature: Group manipulations
  Scenario: Create a New Group
    Given the user is on the Groups page
    When the user clicks the Create Group button
    And the user enters a group name
    And the user enters a group creation date
    And the user enters a group description
    And the user clicks the Create button
    Then the confirmation message should match Group successfully saved

  Scenario: Delete a Group
    When the user clicks on the three dots button for a group
    And the user selects Delete option from the menu bar
    And the user confirms the deletion of the group
    Then the confirmation message should match Group successfully deleted
