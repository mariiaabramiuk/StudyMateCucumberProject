package studymateStepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import studymatePages.TeachersPage;
import utilities.Driver;

import java.time.Duration;

public class TeachersTestSteps {
    String firstNameString;
    String lastNameString;

    WebDriver driver = Driver.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    TeachersPage teachersNewPage = new TeachersPage();

    @Given("the user is on the teachers page")
    public void the_user_is_on_the_teachers_page() {

        wait.until(ExpectedConditions.elementToBeClickable(teachersNewPage.teachersBar));
        teachersNewPage.clickTeachersTab();
    }

    @When("the user clicks on the Add Teacher button")
    public void the_user_clicks_on_the_add_teacher_button() {
        wait.until(ExpectedConditions.elementToBeClickable(teachersNewPage.addTeacherButton));
        teachersNewPage.addTeacherButton.click();
    }

    @When("the user  fill out teachers information")
    public void the_user_fill_out_teachers_information() {
        Faker faker = new Faker();
        firstNameString = faker.name().firstName();
        teachersNewPage.firstName.sendKeys(firstNameString);
        lastNameString = faker.name().lastName();
        teachersNewPage.lastName.sendKeys(lastNameString);
        teachersNewPage.phoneNumber.sendKeys(faker.phoneNumber().phoneNumber().replace("-", ""));
        teachersNewPage.email.sendKeys(faker.internet().emailAddress());
        teachersNewPage.specialization.sendKeys(faker.job().field());
    }

    @When("the user click Add button")
    public void the_user_click_add_button() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(teachersNewPage.add));
        teachersNewPage.add.click();
        Thread.sleep(4000);
    }

    @Then("the system display message Instructor successfully saved")
    public void the_system_display_message_instructor_successfully_saved() {
//        wait.until(ExpectedConditions.visibilityOf(teachersNewPage.successMessageInstructorSaved));
//        teachersNewPage.assertMessages(teachersNewPage.actualSuccessMessageInstructorSaved, teachersNewPage.successMessageInstructorSaved);

        for (WebElement e : teachersNewPage.listOfAddedTeachers) {
            if (e.getText().contains(firstNameString) && e.getText().contains(lastNameString)) {
                Assert.assertTrue(e.getText().contains(firstNameString) && e.getText().contains(lastNameString));
                teachersNewPage.addedTeachersFirstName = firstNameString;
            }
        }
    }


    @When("the user click on three dots button")
    public void the_user_click_on_three_dots_button() {

        wait.until(ExpectedConditions.elementToBeClickable(teachersNewPage.threeDotsTeachers));
        teachersNewPage.clickOnThreeDotsButton();
    }

    @When("the user click on edit button")
    public void the_user_click_on_edit_button() {
        wait.until(ExpectedConditions.elementToBeClickable(teachersNewPage.editButton));
        teachersNewPage.clickOnEditButton();
    }

    @When("the user changes first name of the teacher")
    public void the_user_changes_first_name_of_the_teacher() {
        teachersNewPage.firstName.sendKeys("edit");
    }

    @When("the user clicks on the Save button")
    public void the_user_clicks_on_the_save_button() {
        wait.until(ExpectedConditions.elementToBeClickable(teachersNewPage.saveEditTeacherButton));
        teachersNewPage.clickOnSaveTeacherButton();
    }

    @Then("the system display message Instructor successfully updated")
    public void the_system_display_message_instructor_successfully_updated() {
        wait.until(ExpectedConditions.visibilityOf(teachersNewPage.successMessageInstructorUpdated));
        teachersNewPage.assertMessages(teachersNewPage.actualSuccessMessageInstructorUpdated, teachersNewPage.successMessageInstructorUpdated);
    }

    @When("the user click delete button")
    public void the_user_click_delete_button() {
        wait.until(ExpectedConditions.elementToBeClickable(teachersNewPage.deleteButton));
        teachersNewPage.clickDeleteButton();
    }

    @When("the user confirm deletion of a teacher")
    public void the_user_confirm_deletion_of_a_teacher() {
        wait.until(ExpectedConditions.elementToBeClickable(teachersNewPage.confirmDeleteButton));
        teachersNewPage.clickConfirmDeleteButton();
    }

    @Then("the system display message Instructor successfully deleted")
    public void the_system_display_message_instructor_successfully_deleted() {
        wait.until(ExpectedConditions.visibilityOf(teachersNewPage.successMessageInstructorDeleted));
        teachersNewPage.assertMessages(teachersNewPage.actualSuccessMessageInstructorDeleted, teachersNewPage.successMessageInstructorDeleted);

    }

}
