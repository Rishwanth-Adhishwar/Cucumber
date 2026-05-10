package stepDefinition;

import io.cucumber.datatable.DataTable;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import hooks.DemoBlazeApplicationHook;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginWithMultipleValuesDT {
	WebDriver driver = DemoBlazeApplicationHook.driver;
	WebDriverWait wait = DemoBlazeApplicationHook.wait;

	@Given("The user is in DemoBlazeWebApp")
	public void the_user_is_in_demo_blaze_web_app() {
		driver.get("https://demoblaze.com/");

	}

	@Then("The user enters valid usernames and passwords and clicks login button")
	public void the_user_enters_valid_usernames_and_passwords_and_clicks_login_button(
			io.cucumber.datatable.DataTable dataTable) {

		List<Map<String, String>> user = dataTable.asMaps(String.class, String.class);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#login2"))).click();
		for (Map<String, String> form : user) {
			String name = form.get("username");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername"))).sendKeys(name);
			String pass = form.get("password");
			driver.findElement(By.id("loginpassword")).sendKeys(pass);
			driver.findElement(By.xpath("//button[text()='Log in']")).click();
			String actual = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='logout2']")))
					.getText();
			Assert.assertEquals(actual, "Log out");

		}

	}

}
