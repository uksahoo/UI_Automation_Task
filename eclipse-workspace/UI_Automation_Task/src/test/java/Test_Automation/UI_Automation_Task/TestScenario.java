package Test_Automation.UI_Automation_Task;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import drivercore.DriverFactory;
import locators.HomePage;

public class TestScenario extends DriverFactory {

	WebElement pageTitle = driver.get().findElement(By.xpath("//*[text()='Welcome to the Simple Travel Agency!']"));
	WebElement fromCity = driver.get().findElement(By.xpath("//select[@name='fromPort']"));
	Select selectFromCity = new Select(fromCity);
	WebElement toCity = driver.get().findElement(By.xpath("//select[@name='toPort']"));
	Select selectToCity = new Select(toCity);
	WebElement findFlights = driver.get().findElement(By.xpath("//input[@type='submit']"));
	
	public TestScenario() {
		PageFactory.initElements(driver.get(), this);
	}

	@Test(description = "Verify page is navigating to landing screen and validate page contents")
	public void scenario1() {

		System.out.println("Loading URL........");
		assertTrue(driver.get().getTitle().equals("BlazeDemo"));
		assertTrue(pageTitle.getText().equals("Welcome to the Simple Travel Agency!"));
		assertTrue(fromCity.isDisplayed());
		assertTrue(fromCity.isEnabled());
		assertTrue(toCity.isDisplayed());
		assertTrue(toCity.isEnabled());
	}

	@Test(description = "Select the City and search flight")
	public void scenario2() throws InterruptedException {

		List<WebElement> listOfFlights = driver.get().findElements(By.xpath("//input[@value='Choose This Flight']"));
		// Step 1:
		fromCity.click();
		selectFromCity.selectByVisibleText("Boston");
		// Step 2:
		toCity.click();
		selectToCity.selectByVisibleText("Rome");
		// Step 3:
		findFlights.click();
		Thread.sleep(5000);
		assertTrue(driver.get().findElements(By.xpath("//input[@value='Choose This Flight']")).size() > 0);
	}
}
