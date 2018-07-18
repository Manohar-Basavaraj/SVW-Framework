package softvision.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import validators.UrlValidator;

public class SitemapFetchStepDefs {
	protected WebDriver driver;
	private boolean doesMapExist;
	private String autUrl;
	
	@Before
	public void setUp() {
		String driverName = "webdriver.chrome.driver";
		String driverPath = "C:\\chromedriver_win32\\chromedriver.exe";
		System.setProperty(driverName, driverPath);
		driver = new ChromeDriver();
	}
	
	@Given ("the user is on \"([^\"]*)\" site")
	public void navigateToSite(String siteUrl) {
		autUrl = siteUrl;
		driver.get(siteUrl);
		driver.manage().window().maximize();
	}
	
	@When ("the user checks for the sitemap")
	public void checkForSiteMap() {
		doesMapExist = UrlValidator.doesSitemapExist(autUrl, driver);
	}
	
	@Then ("the user should be shown whether the site has a sitemap")
	public void doesSiteMapExist() {
		Assert.assertTrue(doesMapExist);
	}
	
	@After
	public void shutDown() {
		driver.close();
		driver.quit();
	}
}
