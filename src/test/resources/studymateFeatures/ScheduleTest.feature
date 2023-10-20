@ScheduleTest
Feature: Schedule manipulations

  Scenario: Add an Event
    Given the user is on the Schedule page
    When the user clicks the Create Event button
    And the user enters the current date in the date input field
    And the user enters the current time in the start time field
    And the user enters a future time in the end time field
    And the user enters a event name
    And the user selects a group for the event
    And the user clicks the Publish button
    Then the confirmation message should match the expected message Event successfully saved

  Scenario: Delete an Event

    When the user clicks on a created event
    And the user clicks the delete icon
    And the user confirms the event deletion
    Then the confirmation message should match the expected message Event successfully deleted
