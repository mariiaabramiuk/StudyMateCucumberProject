@TestAnnouncement
Feature: Announcement Tests

  Scenario: Add an Announcement

    Given the user is on the Announcements page
    When the user clicks the Add an announcement button
    And the user enters announcement text into announcement input field
    And the user clicks the checkbox to target all groups
    And the user selects For All from the dropdown
    And the user clicks the Add button
    Then the system should display a message Announcement successfully saved

  Scenario: Edit an Announcement
    When the user clicks the three dots button for an announcement
    Then the user selects Edit from the menu
    And the user clears the existing text and adds modified text
    And the user clicks the Save button
    Then the system should display a message Announcement successfully saved

  Scenario: Cancel Editing an Announcement
    When the user clicks the three dots button for an announcement
    And the user selects Edit from the menu
    Then the user clears the existing text and adds modified text
    And the user clicks the Cancel button

  Scenario: Delete an Announcement
    When the user clicks the three dots button for an announcement
    And the user selects Delete from the menu
    And the user confirms the deletion
    Then the system should display a message ANNOUNCEMENT successfully deleted
