package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "html:target/report2.html",
                "json:target/cucumber-reports/cucumber2.json",
                "rerun:target/rerun2.txt"
        },
        features = "src/test/java/resources/features",
        glue = "step_definitions",
        stepNotifications = true,
        dryRun = false
        ,tags = "@US1022"
)
public class TwoRunner {
}
