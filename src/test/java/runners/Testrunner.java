package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;



@RunWith(Cucumber.class)
@CucumberOptions(
        //path of the feature directory
        features = "src/test/resources/features/",
        //path of the steps package, name must be same
        glue = "steps",
        dryRun = false,
        //tags="@add"
       plugin = {"pretty","html:target/cucumber.html","json:target/jsonReports/cucumber.json"}

)
public class Testrunner {
}
