package studymatePages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class TeachersPage {
    public TeachersPage() { PageFactory.initElements(Driver.getDriver(), this);}
    public String urlTeachers = "https://codewiser.studymate.us/admin/teachers?size=6&page=1";
    @FindBy(xpath = "//nav/a[@href='/admin/teachers']")
    public WebElement teachersBar;
    @FindBy(xpath = "//button[text()='Add teacher']")
    public WebElement addTeacherButton;
    @FindBy(css = "input[name=name]")
    public WebElement firstName;
    @FindBy(css = "input[name=lastName]")
    public WebElement lastName;

    @FindBy(css = "input[name=phoneNumber]")
    public WebElement phoneNumber;
    @FindBy(css = "input[name=email]")
    public WebElement email;
    @FindBy(css = "input[name=specialization]")
    public WebElement specialization;
    @FindBy(xpath = "//button[text()='Add']")
    public WebElement add;

    @FindBy(css = "tr.css-14qv2z4")
    public List<WebElement> listOfAddedTeachers;
    public String addedTeachersFirstName;
    public String actualSuccessMessageInstructorSaved = "Instructor successfully saved";
    public String actualSuccessMessageInstructorUpdated = "Instructor successfully updated";
    public String actualSuccessMessageInstructorDeleted = "Instructor successfully deleted";
    @FindBy(xpath = "//div/p[text()='Instructor successfully saved']")
    public WebElement successMessageInstructorSaved;
    @FindBy(xpath = "//div/p[text()='Instructor successfully updated']")
    public WebElement successMessageInstructorUpdated;
    @FindBy(xpath = "//div/p[text()='Instructor successfully deleted']")
    public WebElement successMessageInstructorDeleted;
    @FindBy(xpath = "(//div[@class='css-yys58j']/button)[1]")
    public WebElement threeDotsTeachers;
    @FindBy(xpath = "(//ul/li[text()='Edit'])[1]")
    public WebElement editButton;
    @FindBy(xpath = "(//ul/li[text()='Delete'])[1]")
    public WebElement deleteButton;
    @FindBy(xpath = "//button[text()='Save']")
    public WebElement saveEditTeacherButton;
    @FindBy(xpath = "//button[text()='Delete']")
    public WebElement confirmDeleteButton;
    @FindBy(xpath = "//button[@aria-label='Go to next page']")
    public WebElement arrowForward;
    public void clickTeachersTab() {
        teachersBar.click();
    }

    public void assertMessages(String expected, WebElement actual) {
        Assert.assertEquals(expected, actual.getText());
    }
    public void clickOnThreeDotsButton() {
        threeDotsTeachers.click();
    }

    public void clickOnEditButton() {
        editButton.click();
    }

    public void clickDeleteButton() {
        deleteButton.click();
    }

    public void clickOnSaveTeacherButton() {
        saveEditTeacherButton.click();
    }

    public void clickConfirmDeleteButton() {
        confirmDeleteButton.click();
    }



}
