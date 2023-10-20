package studymateStepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import studymatePages.AnnouncementsPage;
import utilities.Driver;

import java.time.Duration;

public class AnnouncementsTestSteps {
    WebDriver driver = Driver.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    AnnouncementsPage announcementsPage = new AnnouncementsPage();


    @Given("the user is on the Announcements page")
    public void the_user_is_on_the_announcements_page() throws InterruptedException {
        Thread.sleep(3000);
        announcementsPage.clickAnnouncementsBar();
    }

    @When("the user clicks the Add an announcement button")
    public void the_user_clicks_the_add_an_announcement_button() {
        wait.until(ExpectedConditions.elementToBeClickable(announcementsPage.addAnnouncementButton));
        announcementsPage.clickAddAnnouncementButton();
    }

    @When("the user enters announcement text into announcement input field")
    public void the_user_enters_announcement_text_into_announcement_input_field() {
        announcementsPage.enterAnnouncementText(announcementsPage.testAnnouncementMessage);
    }

    @When("the user clicks the checkbox to target all groups")
    public void the_user_clicks_the_checkbox_to_target_all_groups() {
        announcementsPage.clickOnDropdownToTargetAllGroups();
    }

    @When("the user selects For All from the dropdown")
    public void the_user_selects_for_all_from_the_dropdown() {
        announcementsPage.selectForAllOptionFromDropdown();
    }

    @When("the user clicks the Add button")
    public void the_user_clicks_the_add_button() {
        wait.until(ExpectedConditions.elementToBeClickable(announcementsPage.addButton));
        announcementsPage.clickAddButton();
    }

    @Then("the system should display a message Announcement successfully saved")
    public void the_system_should_display_a_message_announcement_successfully_saved() throws InterruptedException {
       wait.until(ExpectedConditions.visibilityOf(announcementsPage.successMessage));
        announcementsPage.assertSuccessMessage();
     }


    @When("the user clicks the three dots button for an announcement")
    public void the_user_clicks_the_three_dots_button_for_an_announcement() throws InterruptedException {
        Thread.sleep(3000);
        wait.until(ExpectedConditions.elementToBeClickable(announcementsPage.threeDots));
        announcementsPage.clickThreeDotsButton();
    }

    @Then("the user selects Edit from the menu")
    public void the_user_selects_edit_from_the_menu() {
        announcementsPage.selectEditOptionFromMenu();
    }

    @Then("the user clears the existing text and adds modified text")
    public void the_user_clears_the_existing_text_and_adds_modified_text() {
        announcementsPage.clearAnnouncementText();
        announcementsPage.enterAnnouncementText(announcementsPage.modifiedText);

    }

    @Then("the user clicks the Save button")
    public void the_user_clicks_the_save_button() {
        announcementsPage.clickSaveButton();

    }


    @When("the user clicks the Cancel button")
    public void the_user_clicks_the_cancel_button() {
        wait.until(ExpectedConditions.elementToBeClickable(announcementsPage.cancelButton));
        announcementsPage.clickCancelButton();
    }

    @When("the user selects Delete from the menu")
    public void the_user_selects_delete_from_the_menu() {
        wait.until(ExpectedConditions.elementToBeClickable(announcementsPage.deleteButton));
        announcementsPage.clickDeleteButton();
    }

    @When("the user confirms the deletion")
    public void the_user_confirms_the_deletion() {
        wait.until(ExpectedConditions.elementToBeClickable(announcementsPage.confirmDeleteButton));
        announcementsPage.clickConfirmDeleteButton();
    }

    @Then("the system should display a message ANNOUNCEMENT successfully deleted")
    public void the_system_should_display_a_message_announcement_successfully_deleted() {
        wait.until(ExpectedConditions.visibilityOf(announcementsPage.confirmationDeleteText));
        announcementsPage.assertDeleteConfirmation();
    }


}
