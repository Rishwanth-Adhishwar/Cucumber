package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import hooks.DemoBlazeApplicationHook;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class InvalidLoginScenarioOutlineSD {
	WebDriver driver = DemoBlazeApplicationHook.driver;
	WebDriverWait wait = DemoBlazeApplicationHook.wait;

	@Given("The user is in DemoApp website")
	public void the_user_is_in_demo_app_website() {
		
		driver.get("https://demoblaze.com/");
	}

	@When("The user clicks login link")
	public void the_user_clicks_login_link() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#login2"))).click();
	}

	@When("The user enters username as {string} and password as {string}")
	public void the_user_enters_username_as_and_password_as(String string, String string2) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername"))).sendKeys(string);
		driver.findElement(By.id("loginpassword")).sendKeys(string2);
	}

	@When("The user clicks on the login button")
	public void the_user_clicks_on_the_login_button() {
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
	}

	@Then("The error message should be displayed in alert {string}")
	public void the_error_message_should_be_displayed_in_alert(String string) {
		wait.until(ExpectedConditions.alertIsPresent());
		String actual = driver.switchTo().alert().getText();

		if (actual.equals("User does not exist.")) {
			driver.switchTo().alert().accept();
			Assert.assertEquals(actual, string);

		} else if (actual.equals("Please fill out Username and Password.")) {
			driver.switchTo().alert().accept();
			Assert.assertEquals(actual, string);
		} else if (actual.equals("Wrong password.")) {
			driver.switchTo().alert().accept();
			Assert.assertEquals(actual, string);
		}

	}
}