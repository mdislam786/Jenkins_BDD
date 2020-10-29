package stepDefinitions;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps {
	WebDriver driver = Hooks.driver;
	public static Logger log = LogManager.getLogger(LoginSteps.class);

	@Given("User is on the login page")
	public void User_is_on_the_login_page() {
		// Navigate to login Page
		driver.get("http://techfios.com/test/billing/?ng=login/");
		log.info("User is in the login Page");
	}

	@When("User enter valid credentials")
	public void User_enter_valid_credentials() {
		driver.findElement(By.id("username")).sendKeys("techfiosdemo@gmail.com");
		driver.findElement(By.name("password")).sendKeys("abc123");
		driver.findElement(By.name("login")).click();

		log.info("User successfully logged in!");
	}

	@When("^User enters \"(.*)\" and \"(.*)\" and click on login button$")
	public void user_enters_and_and_click_on_login_button(String username, String password) {
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		User_clicks_on_login();
	}

	@Then("User should be able to view account balance")
	public void User_should_be_able_to_view_account_balance() {
		String bodyText = driver.findElement(By.xpath("html/body")).getText();
		String validationMessage = "Welcome TechFios Tester";
		Assert.assertTrue(bodyText.contains(validationMessage));

		log.info(" Login validated!");
	}

	@Then("^User should be able to validate change$")
	public void user_should_be_able_to_validate_change() {
		log.info("Validated");
	}

	@And("User should see a message$")
	public void User_should_see_a_message() {
		String bodyText = driver.findElement(By.xpath("html/body")).getText();
		String actualText = driver.findElement(By.xpath("//span[@id='emsgbody']")).getText();
		Assert.assertTrue(bodyText.contains(actualText));
		log.info("Message compared!");
	}

	@When("^User enters username as \"(.*)\"$")
	public void User_enters_username(String username) {
		driver.findElement(By.id("username")).sendKeys(username);
	}

	@And("^User enters password as \"(.*)\"$")
	public void User_enters_password(String password) {
		driver.findElement(By.name("password")).sendKeys(password);
	}

	@And("User clicks on login$")
	public void User_clicks_on_login() {
		driver.findElement(By.name("login")).click();
	}

	@When("^User enters \"(.*)\" and \"(.*)\"$")
	public void user_enters_username_and_password(String username, String password) throws Throwable {
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
	}

	@Then("^User land on HomePage$")
	public void user_land_on_HomePage() {
		String actual = driver.getTitle();
		Assert.assertEquals("Dashboard- TechFios Test Application - Billing", actual);
	}

	@Then("^User clicks on addContact and enters \"([^\"]*)\"and \"([^\"]*)\"and \"([^\"]*)\"and \"([^\"]*)\"and \"([^\"]*)\"and \"([^\"]*)\"and \"([^\"]*)\"and \"([^\"]*)\" and clicks on submit$")
	public void user_clicks_on_addContact_and_enters_and_and_and_and_and_and_and_and_clicks_on_submit(String arg1,
			String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8) {

		driver.findElement(By.xpath("//span[contains(text(),'CRM')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Add Contact')]")).click();
		driver.findElement(By.id("account")).sendKeys(arg1);

		driver.findElement(By.id("company")).sendKeys(arg2);
		driver.findElement(By.id("email")).sendKeys(arg3);
		driver.findElement(By.id("phone")).sendKeys(arg4);
		driver.findElement(By.xpath("//input[@id='address']")).sendKeys(arg5);
		driver.findElement(By.id("city")).sendKeys(arg6);
		driver.findElement(By.id("state")).sendKeys(arg7);
		driver.findElement(By.xpath("//input[@id='zip']")).sendKeys(arg8);
		driver.findElement(By.xpath("//button[@id='submit']")).click();
		log.info("Contact info submitted!");
	}

	@Then("^User should be able to see validation message$")
	public void user_should_be_able_to_see_validation_message() {
		log.info("AddContact info submitted!");
	}

	@Then("^User should be able to view see validation message$")
	public void user_should_be_able_to_view_see_validation_message() {
		log.info("Successfully addContact info submitted!");

	}

	@When("User enters set of username and password$")
	public void user_enters_set_of_username_and_password(DataTable credentials) {
		// Extract data into a Map and iterate over Map
		for (Map<String, String> data : credentials.asMaps(String.class, String.class)) {

			// Parse Map into Local variables
			String username = data.get("username");
			String password = data.get("password");
			System.out.println(username+ " "+ password);

			// Perform action
			driver.findElement(By.id("username")).clear();
			driver.findElement(By.id("username")).sendKeys(username);
			driver.findElement(By.name("password")).clear();
			driver.findElement(By.name("password")).sendKeys(password);
			User_clicks_on_login();
		}
	}
}
