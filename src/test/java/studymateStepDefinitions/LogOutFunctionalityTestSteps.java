package studymateStepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import studymatePages.*;
import utilities.Config;
import utilities.Driver;

import java.time.Duration;

public class LogOutFunctionalityTestSteps {
    WebDriver driver = Driver.getDriver();
    LogOutPage logOutPage = new LogOutPage();
    LoginPage loginPage = new LoginPage();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    SchedulePage schedulePage = new SchedulePage();


//    @Given("the user is logged in and is on a web application page")
//    public void the_user_is_logged_in_and_is_on_a_web_application_page() {
//        driver.get(Config.getProperty("studyMateURL"));
//        loginPage.enterUsername(loginPage.validUsername);
//        loginPage.enterPassword(loginPage.validPassword);
//        loginPage.clickLoginButton();
//    }

    @When("the user clicks on Administrator button in the user profile")
    public void the_user_clicks_on_administrator_button_in_the_user_profile() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(logOutPage.administratorButton));
        logOutPage.clickAdministratorButton();
    }

    @When("the user clicks on the Logout button in the user profile")
    public void the_user_clicks_on_the_logout_button_in_the_user_profile() {
        logOutPage.clickLogOutButton();
    }

    @Then("the user should see a confirmation message Do you really want to log out?")
    public void the_user_should_see_a_confirmation_message_do_you_really_want_to_log_out() {
        wait.until(ExpectedConditions.visibilityOf(logOutPage.confirmationMessage));
        logOutPage.assertActualAndExpectedMessages(logOutPage.expectedConfirmationMessage, logOutPage.confirmationMessage);
    }

    @When("the user presses the cancel button")
    public void the_user_presses_the_cancel_button() {
        logOutPage.clickCancelButton();
    }

    @Then("the user should stay on the current web application page")
    public void the_user_should_stay_on_the_current_web_application_page() {
        wait.until(ExpectedConditions.urlMatches(schedulePage.scheduleURL));
        Assert.assertEquals(driver.getCurrentUrl(), schedulePage.scheduleURL);
    }

    @Then("the user should confirm logout")
    public void the_user_should_confirm_logout() {
        logOutPage.clickConfirmLogoutButton();
    }

    @Then("the system should redirect the user to the login page")
    public void the_system_should_redirect_the_user_to_the_login_page() {
        wait.until(ExpectedConditions.urlMatches(loginPage.loginUrl));
        Assert.assertEquals(loginPage.loginUrl, driver.getCurrentUrl());
    }

}
