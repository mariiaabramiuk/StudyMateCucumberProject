@TeacherTest
Feature: Teachers manipulations

  Scenario: Add teacher
    Given the user is on the teachers page
    When the user clicks on the Add Teacher button
    And the user  fill out teachers information
    And the user click Add button
    Then the system display message Instructor successfully saved

  Scenario:Edit teacher
    When the user click on three dots button
    And the user click on edit button
    And the user changes first name of the teacher
    And the user clicks on the Save button
    Then the system display message Instructor successfully updated

  Scenario: Delete teacher
    When the user click on three dots button
    And the user click delete button
    And the user confirm deletion of a teacher
    Then the system display message Instructor successfully deleted

