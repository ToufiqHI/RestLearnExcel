package BDD.cucumber.Options;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/BDD/feature",
        glue = "BDD.stepDefinition",
        strict = true,
        plugin = {"pretty", "json:target/cucumber-report.json"}
)
public class Runner
{
//#tags = {"@DeletePlace"},

}
