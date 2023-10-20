@CourseTest
Feature: Courses Manipulation

  Scenario: Create a Course
    Given the user is on the Create Course page
    When the user clicks the Create Course button
    And the user enter a course name
    And the user enters a course description
    And the user enters the current date
    And the user clicks on the Create button
    Then the course should be created successfully

#  Scenario: Assign a teacher
#    When the user clicks on the three dots button for a course
#    And the user clicks assign a teacher button
#    And the user picks the teacher from the list
#    And the user clicks the save button
#    Then the instructor has to be successfully added


  Scenario:  Edit a course
    When the user clicks on the three dots button for a course
    And the user clicks on Edit button
    And the user edit the name
    And the user clicks the save button
    Then the course should be successfully updated


  Scenario: Delete a course
    When the user clicks on the three dots button for a course
    And the user clicks on Delete button
    And the user confirm deletion of the course
    Then the course should be deleted successfully


