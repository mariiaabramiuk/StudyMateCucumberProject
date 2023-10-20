package studymateStepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import studymatePages.StudentPage;
import utilities.Driver;

import java.time.Duration;


public class StudentTestSteps {

    WebDriver driver = Driver.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    StudentPage studentPage = new StudentPage();

    @Given("The user is on the Students tab")
    public void the_user_is_on_the_students_tab() {
        // Navigate to the Students tab
        wait.until(ExpectedConditions.elementToBeClickable(studentPage.studentTab));
        studentPage.navigateToStudentsTab();
    }

    @When("clicks the add student button")
    public void clicks_the_add_student_button() throws InterruptedException {
        // Click the "Add Student" button
        wait.until(ExpectedConditions.elementToBeClickable(studentPage.addStudentButton));
        studentPage.clickAddStudentButton();
    }


    @When("fills in student information and adds the student")
    public void fills_in_student_information_and_adds_the_student() throws InterruptedException {
        // Fill in student information, select group and study format, and click "Add" button
        studentPage.fillStudentInformation();
        wait.until(ExpectedConditions.elementToBeClickable(studentPage.groupDropdown));
        studentPage.groupDropdown.click();
        wait.until(ExpectedConditions.elementToBeClickable(studentPage.groupOption));
        studentPage.groupOption.click();
        studentPage.selectStudyFormat();
        wait.until(ExpectedConditions.elementToBeClickable(studentPage.addButton));
        studentPage.clickAddButton();

        // Wait for 5 seconds (consider using more specific waits based on application behavior)
        Thread.sleep(5000);
    }

    @Then("the number of students should increase")
    public void the_number_of_students_should_increase() {
        // Verify that the number of students is now "from 2"
        studentPage.waitForNumberOfStudents("from 2");
        Assert.assertEquals("from 2", studentPage.getNumberOfStudentsText());
    }


    @When("clicks the three dots button under actions next to a student and confirms deletion")
    public void clicks_the_three_dots_button_under_actions_next_to_a_student_and_confirms_deletion() throws InterruptedException {

        // Click the "Delete" button
        wait.until(ExpectedConditions.elementToBeClickable(studentPage.deleteButton));
        studentPage.clickDeleteButton();

        // Click the "Delete" option
        wait.until(ExpectedConditions.elementToBeClickable(studentPage.deleteOption));
        studentPage.clickDeleteOption();

        // Click the "Final Delete" button
        wait.until(ExpectedConditions.elementToBeClickable(studentPage.finalDeleteButton));
        studentPage.clickFinalDeleteButton();

        // Wait for 5 seconds
        Thread.sleep(5000);

    }

    @Then("the number of students should decrease")
    public void the_number_of_students_should_decrease() {
        // Verify that the number of students is now "from 1"
        studentPage.waitForNumberOfStudentsAfterDeletion("from 1");
        Assert.assertEquals("from 1", studentPage.getNumberOfStudentsText());
    }
}
