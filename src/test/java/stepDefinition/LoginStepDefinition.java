package stepDefinition;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import hooks.DemoBlazeApplicationHook;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinition {
	WebDriver driver=DemoBlazeApplicationHook.driver;
	WebDriverWait wait=DemoBlazeApplicationHook.wait;
	
	@Given("The user is in DemoBlaze Website")
	public void the_user_is_in_demo_blaze_website() {
		driver.get("https://demoblaze.com/");
	    
	}

	@When("The user clicks on Login link")
	public void the_user_clicks_on_login_link() {
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#login2"))).click();
	}

	@When("The user enters valid admin and valid admin")
	public void the_user_enters_valid_admin_and_valid_admin() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername"))).sendKeys("admin");
		driver.findElement(By.id("loginpassword")).sendKeys("admin");
	}

	@When("The user clicks login button")
	public void the_user_clicks_login_button() {
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
	}

	@Then("The user name should be dispayed with Welcome username")
	public void the_user_name_should_be_dispayed_with_welcome_username() {
		String actual=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#nameofuser"))).getText();
	    Assert.assertEquals(actual, "Welcome admin");
	    System.out.println("Login Successful");
	}
	
	@When("The user enters invalid testAdmin and valid admin")
	public void the_user_enters_invalid_test_admin_and_valid_admin() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername"))).sendKeys("testAdmin");
		driver.findElement(By.id("loginpassword")).sendKeys("admin");
	}

	@Then("The user should see a alert message {string}.")
	public void the_user_should_see_a_alert_message(String string) {
	   wait.until(ExpectedConditions.alertIsPresent());
	   
	}
	

}
