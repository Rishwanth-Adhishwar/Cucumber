package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import hooks.DemoBlazeApplicationHook;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PaymentStepDefiniton {
	
	WebDriver driver=DemoBlazeApplicationHook.driver;
	WebDriverWait wait=DemoBlazeApplicationHook.wait;
	
	@Given("The user is in DemoBlaze WebApp")
	public void the_user_is_in_demo_blaze_web_app() {
	    driver.get("https://demoblaze.com/");
	}

	@When("The user clicks on a Phone")
	public void the_user_clicks_on_a_phone() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Samsung galaxy s6']"))).click();
	}

	@When("The user clicks on Add to cart button in Phones description page")
	public void the_user_clicks_on_add_to_cart_button_in_phones_description_page() {
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Add to cart']"))).click();

	}

	@When("The Application should send an alert message {string}")
	public void the_application_should_send_an_alert_message(String string) {
		wait.until(ExpectedConditions.alertIsPresent());
		String actual= driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		Assert.assertEquals(actual, "Product added");
	}

	@When("The user shoud move to cart  Page")
	public void the_user_shoud_move_to_cart_page() {
		driver.findElement(By.cssSelector("#cartur")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='Samsung galaxy s6']")));
	}

	@When("The added Phone should be in cart")
	public void the_added_phone_should_be_in_cart() {
		String actual=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='Samsung galaxy s6']"))).getText();
	    Assert.assertEquals(actual, "Samsung galaxy s6");
	}

	@When("The user clicks on Place Order button")
	public void the_user_clicks_on_place_order_button() {
	  driver.findElement(By.xpath("//button[text()='Place Order']")).click();
	}

	@When("Enter the order details name and credit card Number")
	public void enter_the_order_details_name_and_credit_card_number() {
	   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='name']"))).sendKeys("Rishwa");
	   driver.findElement(By.xpath("//input[@id='card']")).sendKeys("345612980765");
	   driver.findElement(By.xpath("//button[text()='Purchase']")).click();
	}

	@Then("a pop should be displayed with message Thank you for purchase")
	public void a_pop_should_be_displayed_with_message_thank_you_for_purchase() {
	    String actual=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[normalize-space()='Thank you for your purchase!']"))).getText();
	    Assert.assertEquals(actual, "Thank you for your purchase!");
	}



}
