import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * Wires Cucumber into the JUnit libraries, so we can run from maven.
 */
@RunWith(Cucumber.class)
@CucumberOptions(format = { "json", "json:target/cucumber.json" })
public class RunCucumber {
}
