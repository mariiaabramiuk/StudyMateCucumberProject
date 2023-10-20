package studymateStepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import studymatePages.CoursePage;
import studymatePages.TeachersPage;
import utilities.Driver;
import utilities.SeleniumUtilities;

import java.time.Duration;

public class CoursesTestSteps {
    WebDriver driver = Driver.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    CoursePage coursePageNew = new CoursePage();
    TeachersPage teachersNewPage = new TeachersPage();


    @Given("the user is on the Create Course page")
    public void the_user_is_on_the_create_course_page(){
        wait.until(ExpectedConditions.elementToBeClickable(coursePageNew.coursesBar));
        coursePageNew.clickOnCourseBar();

    }
    @When("the user clicks the Create Course button")
    public void the_user_clicks_the_create_course_button() throws InterruptedException {
        Thread.sleep(3000);
        wait.until(ExpectedConditions.elementToBeClickable(coursePageNew.createCourseButton));
        coursePageNew.clickCreateCourseButton();
    }
    @When("the user enter a course name")
    public void the_user_enter_a_course_name() {
        wait.until(ExpectedConditions.elementToBeClickable(coursePageNew.courseName));
        Faker faker = new Faker();
        String generatedCourseName = faker.educator().course();
        coursePageNew.courseName.sendKeys(generatedCourseName);
    }
    @When("the user enters a course description")
    public void the_user_enters_a_course_description() {
        wait.until(ExpectedConditions.elementToBeClickable(coursePageNew.description));
        Faker faker = new Faker();
        String generatedCourseDescription = faker.harryPotter().location();
        coursePageNew.description.sendKeys(generatedCourseDescription);
    }
    @When("the user enters the current date")
    public void the_user_enters_the_current_date() {
        wait.until(ExpectedConditions.elementToBeClickable(coursePageNew.date));

        String currentDate = SeleniumUtilities.getCurrentDate("MM/dd/yyyy");
        coursePageNew.date.click();
        coursePageNew.date.sendKeys(currentDate);
    }
    @When("the user clicks on the Create button")
    public void the_user_clicks_on_the_create_button() {
        wait.until(ExpectedConditions.elementToBeClickable(coursePageNew.create));
        coursePageNew.create.click();
    }

    @Then("the course should be created successfully")
    public void the_course_should_be_created_successfully() {
        wait.until(ExpectedConditions.visibilityOf(coursePageNew.messageSuccessfulCourseCreated));
        coursePageNew.assertMessage(coursePageNew.messageSuccessfulCourseCreated,coursePageNew.expectedMessageSuccessfullyCreated);
    }


    @When("the user clicks on the three dots button for a course")
    public void the_user_clicks_on_the_three_dots_button_for_a_course() {
        wait.until(ExpectedConditions.elementToBeClickable(coursePageNew.threeDots));
        coursePageNew.clickThreeDots();
    }
    @When("the user clicks assign a teacher button")
    public void the_user_clicks_assign_a_teacher_button() throws InterruptedException {
        Thread.sleep(3000);
        wait.until(ExpectedConditions.elementToBeClickable(coursePageNew.assignTeacher));
        coursePageNew.assignTeacher.click();
        coursePageNew.assignTeacherDropdown.click();
        for (WebElement e : coursePageNew.listOfTeachers
        ) {
            if (e.getText().contains(teachersNewPage.addedTeachersFirstName)) {
                e.click();
            }
        }
        Actions actions = new Actions(driver);
        actions.click(coursePageNew.window).build().perform();

     }
    @When("the user picks the teacher from the list")
    public void the_user_picks_the_teacher_from_the_list() {
        coursePageNew.assignTeacherDropdown.click();
    }
    @When("the user clicks the save button")
    public void the_user_clicks_the_save_button() {
        coursePageNew.saveAddedTeacherButton.click();
    }
    @Then("the instructor has to be successfully added")
    public void the_instructor_has_to_be_successfully_added() {
        wait.until(ExpectedConditions.visibilityOf(coursePageNew.instructorAddedSuccessfullyMessage));
        coursePageNew.assertMessage(coursePageNew.instructorAddedSuccessfullyMessage, coursePageNew.expectedMessageInstructorSuccessfullyCreated);
    }

    @When("the user clicks on Edit button")
    public void the_user_clicks_on_edit_button() {
        wait.until(ExpectedConditions.elementToBeClickable(coursePageNew.editCourseButton));
        coursePageNew.clickEditCourseButton();
    }
    @When("the user edit the name")
    public void the_user_edit_the_name() {
        coursePageNew.courseName.sendKeys("edit");
    }

    @Then("the course should be successfully updated")
    public void the_course_should_be_successfully_updated() {
        wait.until(ExpectedConditions.visibilityOf(coursePageNew.actualMessageCourseUpdated));
        coursePageNew.assertMessage(coursePageNew.actualMessageCourseUpdated,coursePageNew.expectedMessageCourseUpdated);
    }

    @When("the user clicks on Delete button")
    public void the_user_clicks_on_delete_button() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(coursePageNew.deleteCourseButton));
        coursePageNew.clickDeleteButtonCourse();

    }
    @When("the user confirm deletion of the course")
    public void the_user_confirm_deletion_of_the_course() {
        coursePageNew.clickConfirmCourseDeletionButton();
    }

    @Then("the course should be deleted successfully")
    public void the_course_should_be_deleted_successfully() {
        wait.until(ExpectedConditions.visibilityOf(coursePageNew.messageCourseDeleted));
        coursePageNew.assertMessage(coursePageNew.messageCourseDeleted,coursePageNew.actualMessageCourseDeleted);

    }
}
