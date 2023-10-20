package studymateStepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import studymatePages.GroupsPage;

import utilities.Driver;

import java.time.Duration;

public class GroupTestSteps {
    WebDriver driver = Driver.getDriver();
    GroupsPage groupsPage = new GroupsPage();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


    @Given("the user is on the Groups page")
    public void the_user_is_on_the_groups_page() {
        wait.until(ExpectedConditions.elementToBeClickable(groupsPage.groups));
        groupsPage.clickGroupTab();

    }

    @When("the user clicks the Create Group button")
    public void the_user_clicks_the_create_group_button() {
        wait.until(ExpectedConditions.elementToBeClickable(groupsPage.createGroupButton));
        groupsPage.clickOnCreateGroupButton();
    }

    @When("the user enters a group name")
    public void the_user_enters_a_group_name() {
        Faker faker = new Faker();
        wait.until(ExpectedConditions.elementToBeClickable(groupsPage.groupName));
        groupsPage.clickGroupNameInputField();
        groupsPage.groupName.sendKeys(faker.job().field());
    }

    @When("the user enters a group creation date")
    public void the_user_enters_a_group_creation_date() {
        wait.until(ExpectedConditions.elementToBeClickable(groupsPage.groupCreationDate));
        groupsPage.groupCreationDate.click();
        groupsPage.passGroupCreationDate();
    }

    @When("the user enters a group description")
    public void the_user_enters_a_group_description() {
        Faker faker = new Faker();
        wait.until(ExpectedConditions.elementToBeClickable(groupsPage.groupDescription));
        groupsPage.clickDescriptionInputField();
        groupsPage.groupDescription.sendKeys(faker.chuckNorris().fact());
    }

    @When("the user clicks the Create button")
    public void the_user_clicks_the_create_button() {
        wait.until(ExpectedConditions.elementToBeClickable(groupsPage.createGroupButton));
        groupsPage.clickCreateButton();
    }

    @Then("the confirmation message should match Group successfully saved")
    public void the_confirmation_message_should_match_group_successfully_saved() throws InterruptedException {
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOf(groupsPage.actualGroupConfirmationMessage));
        Assert.assertEquals(groupsPage.expectedGroupConfirmationMessage, groupsPage.actualGroupConfirmationMessage.getText());

    }

    @When("the user clicks on the three dots button for a group")
    public void the_user_clicks_on_the_three_dots_button_for_a_group() {
        wait.until(ExpectedConditions.elementToBeClickable(groupsPage.threeDots));
        groupsPage.clickOnThreeDots();
    }

    @When("the user selects Delete option from the menu bar")
    public void the_user_selects_delete_option_from_the_menu_bar() {
        wait.until(ExpectedConditions.elementToBeClickable(groupsPage.deleteGroup));
        groupsPage.clickDeleteGroup();

    }

    @When("the user confirms the deletion of the group")
    public void the_user_confirms_the_deletion_of_the_group() {
        wait.until(ExpectedConditions.elementToBeClickable(groupsPage.confirmDeleteButton));
        groupsPage.clickConfirmDeleteButton();

    }

    @Then("the confirmation message should match Group successfully deleted")
    public void the_confirmation_message_should_match_group_successfully_deleted() {

        wait.until(ExpectedConditions.visibilityOf(groupsPage.actualGroupDeletedConfirmationMessage));
        Assert.assertEquals(groupsPage.expectedConfirmationDeleteGroupMessage, groupsPage.actualGroupDeletedConfirmationMessage.getText());
    }


}

