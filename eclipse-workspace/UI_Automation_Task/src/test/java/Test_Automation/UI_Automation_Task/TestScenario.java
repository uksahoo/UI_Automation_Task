package Test_Automation.UI_Automation_Task;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import drivercore.DriverFactory;
import locators.HomePage;

public class TestScenario extends DriverFactory {

	public HomePage home;

	@BeforeTest(alwaysRun = true)

	public void initilization() {
		home = new HomePage();
	}

	@Test(description = "Verify page is navigating to landing screen and validate page contents")
	public void scenario1() {

		System.out.println("Loading URL........");
		assertTrue(driver.get().getTitle().equals("BlazeDemo"));
		home.verifyPageTitle();
		home.verifyFromCityDisplayedAndEnabled();
		home.verifyToCityDisplayedAndEnabled();
	}

	@Test(description = "Select the City and search flight")
	public void scenario2() throws InterruptedException {
		// Step 1:
		home.clickAndSelectFromCity("Boston");
		// Step 2:
		home.clickAndSelectToCity("Rome");
		// Step 3:
		home.clickOnFlightSearchButton();
		Thread.sleep(10);
		home.verifyListOfFlightShown();
	}
}
