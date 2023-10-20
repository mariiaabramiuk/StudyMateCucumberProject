package studymateStepDefinitions;

import com.github.javafaker.Faker;
import hooks.TestUtilities;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import studymatePages.SchedulePage;
import utilities.Driver;

import java.time.Duration;

public class ScheduleTestSteps {
    WebDriver driver = Driver.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    SchedulePage schedulePage = new SchedulePage();


    @Given("the user is on the Schedule page")
    public void the_user_is_on_the_schedule_page() throws InterruptedException {
        Thread.sleep(3000);
        wait.until(ExpectedConditions.elementToBeClickable(schedulePage.scheduleTab));
        schedulePage.clickOnScheduleTab();

    }

    @When("the user clicks the Create Event button")
    public void the_user_clicks_the_create_event_button() {
        wait.until(ExpectedConditions.elementToBeClickable(schedulePage.createEventButton));
        schedulePage.clickCreateEventButton();
    }

    @When("the user enters the current date in the date input field")
    public void the_user_enters_the_current_date_in_the_date_input_field() {
        wait.until(ExpectedConditions.elementToBeClickable(schedulePage.dateInputField));
        schedulePage.clickOnDateInputField();
        TestUtilities.passCurrentDate(schedulePage.dateInputField);
    }

    @When("the user enters the current time in the start time field")
    public void the_user_enters_the_current_time_in_the_start_time_field() {
        wait.until(ExpectedConditions.elementToBeClickable(schedulePage.startTimeField));
        schedulePage.clickOnStartTimeField();
        TestUtilities.passCurrentTime(schedulePage.startTimeField);
    }

    @When("the user enters a future time in the end time field")
    public void the_user_enters_a_future_time_in_the_end_time_field() {
        wait.until(ExpectedConditions.elementToBeClickable(schedulePage.endTimeField));
        schedulePage.clickOnEndTimeField();
        TestUtilities.passFutureTime(schedulePage.endTimeField);
    }

    @When("the user enters a event name")
    public void the_user_enters_a_event_name() {
        schedulePage.clickOnEventNameInputField();
        Faker faker = new Faker();
        schedulePage.eventNameInputField.sendKeys(faker.harryPotter().house());
    }

    @When("the user selects a group for the event")
    public void the_user_selects_a_group_for_the_event() {

        schedulePage.clickChooseGroupDropDown();
        schedulePage.chooseTheGroupCheckBox();
    }

    @When("the user clicks the Publish button")
    public void the_user_clicks_the_publish_button() {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ESCAPE).build().perform();
        wait.until(ExpectedConditions.elementToBeClickable(schedulePage.publishButton));
        schedulePage.clickPublishButton();
    }

    @Then("the confirmation message should match the expected message Event successfully saved")
    public void the_confirmation_message_should_match_the_expected_message_event_successfully_saved() {
        wait.until(ExpectedConditions.visibilityOf(schedulePage.actualMessageEventCreated));
        Assert.assertEquals(schedulePage.expectedMessageEventSuccessfullySaved, schedulePage.actualMessageEventCreated.getText());
    }

    @When("the user clicks on a created event")
    public void the_user_clicks_on_a_created_event() {
        wait.until(ExpectedConditions.elementToBeClickable(schedulePage.createdEventDisplay));
        schedulePage.clickOnCreatedEventDisplay();
    }

    @When("the user clicks the delete icon")
    public void the_user_clicks_the_delete_icon() {
        wait.until(ExpectedConditions.elementToBeClickable(schedulePage.deleteEventIcon));
        schedulePage.clickDeleteIcon();
    }

    @When("the user confirms the event deletion")
    public void the_user_confirms_the_event_deletion() {
        wait.until(ExpectedConditions.elementToBeClickable(schedulePage.confirmDeleteButton));
        schedulePage.clickConfirmDeleteButton();
    }

    @Then("the confirmation message should match the expected message Event successfully deleted")
    public void the_confirmation_message_should_match_the_expected_message_event_successfully_deleted() {
        wait.until(ExpectedConditions.visibilityOf(schedulePage.actualMessageEventDeleted));
        Assert.assertEquals(schedulePage.expectedMessageEventSuccessfullyDeleted, schedulePage.actualMessageEventDeleted.getText());
    }

}
