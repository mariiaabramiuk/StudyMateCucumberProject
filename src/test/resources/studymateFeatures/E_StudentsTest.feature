@StudentTest
Feature: Student Management

  Background:
  Given The user is on the Students tab

  Scenario: Add a Student
    When clicks the add student button
    And fills in student information and adds the student
    Then the number of students should increase

  Scenario: Delete a Student
    When clicks the three dots button under actions next to a student and confirms deletion
    Then the number of students should decrease