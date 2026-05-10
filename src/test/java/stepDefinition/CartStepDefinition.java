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

public class CartStepDefinition {
	WebDriver driver=DemoBlazeApplicationHook.driver;
	WebDriverWait wait=DemoBlazeApplicationHook.wait;

	@Given("The user is in DemoBlaze Application")
	public void the_user_is_in_demo_blaze_application() {
		driver.get("https://demoblaze.com/");
	}

	@When("The user clicks on a Product")
	public void the_user_clicks_on_a_product() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Samsung galaxy s6']"))).click();
		
	}

	@When("The user clicks on Add to cart button in product description page")
	public void the_user_clicks_on_add_to_cart_button_in_product_description_page() {
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Add to cart']"))).click();
	}

	@Then("The Application should send an alert {string}")
	public void the_application_should_send_an_alert(String string) {
		wait.until(ExpectedConditions.alertIsPresent());
		String actual= driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		Assert.assertEquals(actual, "Product added");
		
	}
	
	@When("The user shoud navigate to cart  Page")
	public void the_user_shoud_navigate_to_cart_page() {
		driver.findElement(By.cssSelector("#cartur")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='Samsung galaxy s6']")));
	}

	@Then("The added Product should be in cart")
	public void the_added_product_should_be_in_cart() {
		String actual=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='Samsung galaxy s6']"))).getText();
	    Assert.assertEquals(actual, "Samsung galaxy s6");
	}


}
