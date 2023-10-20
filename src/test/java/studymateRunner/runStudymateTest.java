package studymateRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumber.html", "json:target/report.json", "pretty"},
        features = "/Users/mariiazatylna/Desktop/projects/StudyMateCucumberProject/src/test/resources/studymateFeatures",
        glue = "studymateStepDefinitions",
        tags = "@LoginTest or @LogoutTest or @TestAnnouncement or @FeatureTest or @ScheduleTest or @TeacherTest or @CourseTest or @StudentTest",
        dryRun = false
)
public class runStudymateTest {

}
