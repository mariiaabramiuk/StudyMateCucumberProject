package studymateRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumber.html", "json:target/report.json", "pretty"},
        features = {
                "/Users/mariiazatylna/Desktop/projects/StudyMateCucumberProject/src/test/resources/studymateFeatures/A_LoginFunctionalityTest.feature",
                "/Users/mariiazatylna/Desktop/projects/StudyMateCucumberProject/src/test/resources/studymateFeatures/B_GroupsTest.feature",
                "/Users/mariiazatylna/Desktop/projects/StudyMateCucumberProject/src/test/resources/studymateFeatures/C_TeachersTest.feature",
                "/Users/mariiazatylna/Desktop/projects/StudyMateCucumberProject/src/test/resources/studymateFeatures/D_CoursesTest.feature",
                "/Users/mariiazatylna/Desktop/projects/StudyMateCucumberProject/src/test/resources/studymateFeatures/E_StudentsTest.feature",
                "/Users/mariiazatylna/Desktop/projects/StudyMateCucumberProject/src/test/resources/studymateFeatures/S_AnnouncementsTest.feature",
                "/Users/mariiazatylna/Desktop/projects/StudyMateCucumberProject/src/test/resources/studymateFeatures/ScheduleTest.feature",
                "/Users/mariiazatylna/Desktop/projects/StudyMateCucumberProject/src/test/resources/studymateFeatures/Z_LogOutFunctionality.feature",
        },
        glue = "studymateStepDefinitions",
        tags = "@LoginTest or @LogoutTest or @TestAnnouncement or @FeatureTest or @ScheduleTest or @TeacherTest or @CourseTest or @StudentTest",
        dryRun = false
)
public class runStudymateTest {

}
