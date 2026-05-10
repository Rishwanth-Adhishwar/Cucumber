package stepDefinition;
import io.cucumber.datatable.DataTable;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import hooks.DemoBlazeApplicationHook;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginWithDataTables {
	
	WebDriver driver = DemoBlazeApplicationHook.driver;
	WebDriverWait wait = DemoBlazeApplicationHook.wait;
	
	@Given("The user is in DemoBlazeWeb")
	public void the_user_is_in_demo_blaze_web() {
		driver.get("https://demoblaze.com/");
	}

	@When("The user click login link in page")
	public void the_user_click_login_link_in_page() {
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#login2"))).click();
	}

	@When("The user enters valid username and password  and clicks login Button")
	public void the_user_enters_valid_username_and_password_and_clicks_login_button(io.cucumber.datatable.DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
		List<List<String>> loginForm=dataTable.asLists(String.class);
		String uname1=loginForm.get(1).get(0);
		String upass1=loginForm.get(1).get(1);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername"))).sendKeys(uname1);
		driver.findElement(By.id("loginpassword")).sendKeys(upass1);
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
	}

	@Then("The user name should be dispayed with Welcome username text")
	public void the_user_name_should_be_dispayed_with_welcome_username_text() {
		String actual=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#nameofuser"))).getText();
	    Assert.assertEquals(actual, "Welcome mp34");
	    System.out.println("Login Successful");
	    
	}


}
