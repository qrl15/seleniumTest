package cucumberOptions;


import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/java/features/login.feature",
        glue = "stepDefinitions"
)
public class TestRunner {
}
