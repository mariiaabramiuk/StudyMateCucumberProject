package studymatePages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class CoursePage {
    public CoursePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    public String urlCourse = "https://codewiser.studymate.us/admin/courses";
    @FindBy(xpath = "//button[text()='Create course']")
    public WebElement createCourseButton;

    @FindBy(css = "input[name=courseName]")
    public WebElement courseName;

    @FindBy(css = "textarea[name=description]")
    public WebElement description;

    @FindBy(css = "input[placeholder='MM/DD/YYYY']")
    public WebElement date;

    @FindBy(xpath = "//button[text()='Cancel']")
    public WebElement cancelButton;
    @FindBy(xpath = "//button[text()='Create']")
    public WebElement create;

    @FindBy(css = "div.css-s18byi")
    public List<WebElement> listOfCourses;

    @FindBy(xpath = "//div[@class='css-yys58j'][1]")
    public WebElement threeDots;

    @FindBy(xpath = "(//ul/li[text()='Assign teacher'])[1]")
    public WebElement assignTeacher;

    @FindBy(css = "div.css-qiwgdb")
    public WebElement assignTeacherDropdown;

    @FindBy(xpath = " //div[@role='presentation' and @id='menu-']/div/ul/li")
    public List<WebElement> listOfTeachers;

    @FindBy(xpath = "//button[text()='Save']")
    public WebElement saveAddedTeacherButton;

    @FindBy(xpath = "//div[@class='MuiFormControl-root css-ccwj9y']//div/following::input[1]")
    public WebElement window;

    @FindBy(css = "p.sc-dkrFOg")
    public WebElement instructorAddedSuccessfullyMessage;

    @FindBy(xpath = "//nav/a[@href='/admin/courses']")
    public WebElement coursesBar;

    @FindBy(xpath = "//div/p[text()='The course successfully created']")
    public WebElement messageSuccessfulCourseCreated;

    @FindBy(xpath = "(//ul/li[text()='Delete'])[1]")
    public WebElement deleteCourseButton;

    @FindBy(xpath = "//div/button[text()='Delete']")
    public WebElement confirmCourseDeletionButton;

    public String expectedMessageSuccessfullyCreated = "The course successfully created";

    public String expectedMessageInstructorSuccessfullyCreated  = "Instructors successfully added to the course";

    @FindBy (xpath = "(//ul/li[text()='Edit'])[1]")
    public WebElement editCourseButton;

    public String expectedMessageCourseUpdated = "The course successfully updated";

    @FindBy(xpath = "//div/p[text()='The course successfully updated']")
    public WebElement actualMessageCourseUpdated;

    @FindBy(xpath = "//div/p[text()='The course successfully deleted']")

    public  WebElement messageCourseDeleted;

    public String actualMessageCourseDeleted = "The course successfully deleted";

    public void clickCreateCourseButton() {
        createCourseButton.click();
    }

    public void clickCancelCourseButton() {
        cancelButton.click();
    }

    public void clickCreateButton() {
        create.click();
    }

    public void clickThreeDots() {
        threeDots.click();
    }

    public void clickSaveAddedTeacherButton() {
        saveAddedTeacherButton.click();
    }

    public void clickOnCourseBar() {
        coursesBar.click();
    }

    public void assertMessage(WebElement actualMessage, String expectedMessage) {
        Assert.assertEquals(actualMessage.getText(), expectedMessage);
    }
    public void clickEditCourseButton(){
        editCourseButton.click();
    }

    public void clickDeleteButtonCourse(){
        deleteCourseButton.click();
    }

    public void clickConfirmCourseDeletionButton(){
        confirmCourseDeletionButton.click();
    }

}
