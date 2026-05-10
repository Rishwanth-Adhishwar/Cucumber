package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinitions {
	
	@Given("user is on Home Page")
	public void user_is_on_home_page() {
		System.out.println("Step 1");
	    
	}

	@When("the user enters username as {string}")
	public void the_user_enters_username_as(String string) {
		System.out.println("Step 2");
	}

	@When("the user enters password as {string}")
	public void the_user_enters_password_as(String string) {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Step 3");
	}

	@Then("the user should be able to login Successfully")
	public void the_user_should_be_able_to_login_successfully() {
		System.out.println("Step 4");
	}


}
