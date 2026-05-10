package stepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import hooks.DemoBlazeApplicationHook;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CategoriesStepDefinition {
	WebDriver driver=DemoBlazeApplicationHook.driver;
	WebDriverWait wait=DemoBlazeApplicationHook.wait;
	
	@Given("The user is in DemoBlaze Web Application")
	public void the_user_is_in_demo_blaze_web_application() {
		driver.get("https://demoblaze.com/");
	}



    @When("The user clicks on Phones link in Categories")
    public void the_user_clicks_on_phones_link_in_categories() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Phones']"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[@class='card-title']")));
    }

    @Then("The List of Phones to be displayed")
    public void the_list_of_phones_to_be_displayed() {
        String actual = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Nokia lumia 1520']"))).getText();

        Assert.assertEquals(actual, "Nokia lumia 1520");
    }

    @When("The user clicks on Laptops link in Categories")
    public void the_user_clicks_on_laptops_link_in_categories() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Laptops']"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[@class='card-title']")));
    }

    @Then("The List of Laptops to be displayed")
    public void the_list_of_laptops_to_be_displayed() {
        String actual = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='MacBook Pro']"))).getText();

        Assert.assertEquals(actual, "MacBook Pro");
    }
    
    @When("The user clicks on Monitors link in Categories")
    public void the_user_clicks_on_monitors_link_in_categories() {
    	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Monitors']"))).click();

         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[@class='card-title']")));
    }

    @Then("The List of Monitors to be displayed")
    public void the_list_of_monitors_to_be_displayed() {
        String actual = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='ASUS Full HD']"))).getText();
        Assert.assertEquals(actual, "ASUS Full HD");
    }



}
