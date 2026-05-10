package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(plugin= {"pretty","html:target/cucucmber-reports/Cucumber.html"},
features="src/test/resources/com/features/login.feature",tags="@validCredentialsLogin",
glue="stepDefinition")
public class JunitRunner {

}
