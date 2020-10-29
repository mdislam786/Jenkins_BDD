package stepDefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	public static WebDriver driver;
	public static Logger log = LogManager.getLogger(Hooks.class);
	
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		log.info("Browser Opened");
		
	}

	@After
	public void tearDown() {
		driver.close();
		driver.quit();
		log.info("Browser Closed");
	}
	

}
