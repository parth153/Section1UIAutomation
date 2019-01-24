package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(strict=false, features = "src/test/java/features", glue = {"steps","hooks"}, 
				plugin = {"pretty","json:target/cucumber.json", "html:target/site/cucumber-pretty"},
				tags="@Test",
				monochrome=true)
//Runner class for the cucumber feature files
//will execute all scenarios with @Test tag
//will generate cucumber-pretty report and cucumber.json file
public class TestRunner {

}
