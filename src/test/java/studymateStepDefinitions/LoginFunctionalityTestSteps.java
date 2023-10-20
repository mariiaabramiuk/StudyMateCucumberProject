package studymateStepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import studymatePages.CommonPageAnalytics;
import studymatePages.LogOutPage;
import studymatePages.LoginPage;
import utilities.Config;
import utilities.Driver;

import java.time.Duration;

public class LoginFunctionalityTestSteps {
    WebDriver driver = Driver.getDriver();
    LoginPage loginPage = new LoginPage();
    CommonPageAnalytics commonPageAnalytics = new CommonPageAnalytics();

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    LogOutPage logOutPage = new LogOutPage();

    private String passwordType;

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        driver.get(Config.getProperty("studyMateURL"));
    }

    @When("the user enters a valid username")
    public void the_user_enters_a_valid_username() {
        loginPage.enterUsername(loginPage.validUsername);
    }

    @When("the user enters a shorter then six characters password")
    public void the_user_enters_a_shorter_then_six_characters_password() {
        loginPage.enterPassword(loginPage.shortPassword);
    }

    @Then("the user should see the message Password must be at least 6 characters")
    public void the_user_should_see_the_message() {
        wait.until(ExpectedConditions.visibilityOf(loginPage.shortPasswordMessage));
        loginPage.assertActualAndExpectedMessages(loginPage.getExpectedErrorMessageShortPassword, loginPage.shortPasswordMessage);
    }

    @Then("the username field will get cleared")
    public void the_username_field_will_get_cleared() {
        loginPage.clearEmailField(driver);

    }

    @Then("the password field will get cleared")
    public void the_password_field_will_get_cleared() {
        loginPage.clearPasswordField(driver);

    }

    @When("the user enters an invalid username")
    public void the_user_enters_an_invalid_username() {
        loginPage.enterUsername(loginPage.invalidUsername);
    }

    @When("the user enters a valid password")
    public void the_user_enters_a_valid() {
        loginPage.enterPassword(loginPage.validPassword);
    }

    @Then("the user clicks the Login button")
    public void the_user_clicks_the_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("the system should display an error message for an invalid username")
    public void the_system_should_display_an_error_message_for_an_invalid_username() {
        wait.until(ExpectedConditions.visibilityOf(loginPage.invalidUsernameMessage));
        loginPage.assertActualAndExpectedMessages(loginPage.expectedErrorMessageInvalidUsername, loginPage.invalidUsernameMessage);
    }

    @When("the user enters an invalid password")
    public void the_user_enters_an_invalid_password() {
        loginPage.enterPassword(loginPage.invalidPassword);
    }

    @Then("the system should display an error message for an invalid password")
    public void the_system_should_display_an_error_message_for_an_invalid_password() {
        wait.until(ExpectedConditions.visibilityOf(loginPage.invalidPasswordMessage));
        loginPage.assertActualAndExpectedMessages(loginPage.expectedMessageInvalidPassword, loginPage.invalidPasswordMessage);
    }


    @When("the user enters a valid password and leaves the username field empty")
    public void the_user_enters_a_valid_password_and_leaves_the_username_field_empty() {
        loginPage.enterPassword(loginPage.validPassword);
    }

    @Then("the system should display an error message for an empty username field")
    public void the_system_should_display_an_error_message_for_an_empty_username_field() {
        wait.until(ExpectedConditions.visibilityOf(loginPage.emptyEmailErrorMessage));
        loginPage.assertActualAndExpectedMessages(loginPage.expectedErrorMessageEmptyEmail, loginPage.emptyEmailErrorMessage);
    }

    @When("the user enters a valid username and leaves the password field empty")
    public void the_user_enters_a_valid_username_and_leaves_the_password_field_empty() {
        loginPage.enterUsername(loginPage.validUsername);
    }

    @Then("the system should display an error message for an empty password field")
    public void the_system_should_display_an_error_message_for_an_empty_password_field() {
        wait.until(ExpectedConditions.visibilityOf(loginPage.emptyPasswordErrorMessage));
        loginPage.assertActualAndExpectedMessages(loginPage.expectedErrorMessageEmptyPassword, loginPage.emptyPasswordErrorMessage);
    }

    @Then("the user clicks the reveal password button")
    public void the_user_clicks_the_reveal_password_button() {
        passwordType = loginPage.passwordField.getAttribute("type");
        loginPage.clickShowPasswordButton();

    }

    @Then("the password should be revealed")
    public void the_password_should_be_revealed() throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertNotEquals(passwordType, loginPage.passwordField.getAttribute("type"));
    }

    @When("the user selects the Russian language from the language dropdown")
    public void the_user_selects_the_russian_language_from_the_language_dropdown() {
        loginPage.clickLanguageDropDown();
        loginPage.pickRussianLanguage();
    }

    @Then("the user logs in, and the interface is displayed in Russian")
    public void the_user_logs_in_and_the_interface_is_displayed_in_russian() {
        Assert.assertEquals(loginPage.analyticsInRussian.getText(), "Аналитика");
    }

    @Then("the user logs out successfully")
    public void the_user_logs_out_successfully() {
        logOutPage.clickAdministratorButtonInRussian();
        logOutPage.clickLogOutButton();
        logOutPage.clickConfirmLogoutButtonInRussian();
    }

    @When("the user enters an email in an incorrect format")
    public void the_user_enters_an_email_in_an_incorrect_format() {
        loginPage.enterUsername(loginPage.invalidFormatEmail);
    }

    @Then("the system should display an error message")
    public void the_system_should_display_an_error_message() {
        wait.until(ExpectedConditions.visibilityOf(loginPage.invalidEmailErrorMessage));
        loginPage.assertActualAndExpectedMessages(loginPage.expectedErrorMessageInvalidEmailFormat, loginPage.invalidEmailErrorMessage);
    }


    @Then("the user should be granted access to their account without any error messages")
    public void the_user_should_be_granted_access_to_their_account_without_any_error_messages() {
        wait.until(ExpectedConditions.urlMatches(commonPageAnalytics.analyticsUrl));
        Assert.assertEquals(driver.getCurrentUrl(), commonPageAnalytics.analyticsUrl);

    }


}

