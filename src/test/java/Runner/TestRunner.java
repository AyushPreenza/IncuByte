package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = {"src/test/java/Feature"}, plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        glue = "Steps", tags = "@Incubyte",monochrome = true, dryRun = false)

public class TestRunner extends AbstractTestNGCucumberTests {


}
