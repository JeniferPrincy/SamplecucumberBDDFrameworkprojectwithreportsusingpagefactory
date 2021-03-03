package StepDefinitions;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.Pages.GoogleSearchSteps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchSteps {
	WebDriver driver = null;
	GoogleSearchSteps search;


	@Before
	public void  Browser_setup() {

		String Location=System.getProperty("user.dir");
		System.out.println("The path is "+Location);
		System.setProperty("webdriver.chrome.driver",Location+"//src//test//resources//drivers//chromedriver1.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@After
	public void  Close_Browser() {
		driver.close();
		driver.quit();

	}



	@Given("Browser is open  User is on google search page")
	public void browser_is_open() {
		driver.navigate().to("https://www.google.com");
		System.out.println("=========================GOOGLE SEARCH TO FIND THE NUMBER OF LINKS AVAILABLE============================");


	}


	@When("^User enter a (.*) in google search box$")
	public void user_enter_a_Cucumber_framework_in_google_search_box(String text) {
		search=new  GoogleSearchSteps(driver);  
		search.Search_text(text);
	}

	@And("User Clicks enter button")
	public void user_Clicks_enter_button() {
		search.Clicks_Enter();
	}


	@Then("User is navigated to the search result page")
	public void user_is_navigated_to_the_search_result_page() {
		search.getTitles();
	}


	@And("Gets the number of links available")
	public void gets_the_number_of_links_available() throws IOException {
		search.Available_Links();
		System.out.println("=================================================================================");

	}




}
