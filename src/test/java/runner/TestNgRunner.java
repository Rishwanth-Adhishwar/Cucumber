package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin= {"pretty","html:target/cucucmber-reports/Cucumber.html"},
features="src/test/resources/com/features/loginWithMultipleValuesDT.feature",
glue={"stepDefinition","hooks"})

public class TestNgRunner extends AbstractTestNGCucumberTests{

}
