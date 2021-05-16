package org.example;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "src/test/resources/org/example/ChangePassword.feature",
        glue = "StepDefinitions",
        dryRun = false
)
public class RunCucumberTest {

}
