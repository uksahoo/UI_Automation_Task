package Test_Automation.UI_Automation_Task;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import drivercore.DriverFactory;
import locators.HomePage;

public class TestScenario extends DriverFactory {

	HomePage home;

	@BeforeMethod

	public void initilization() {
		home = new HomePage(driver.get());
	}

	@Test(description = "Verify page is navigating to landing screen and validate page contents")
	public void scenario1() {

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
		home.clickAndSelectToCity("London");
		// Step 3:
		home.clickOnFlightSearchButton();
		Thread.sleep(5000);
		home.verifyListOfFlightShown();
	}
	
	@Test(description = "Verify the price shown with price on payment page")
	public void scenario3() throws InterruptedException {
		// Step 1:
		home.clickAndSelectFromCity("Boston");
		// Step 2:
		home.clickAndSelectToCity("London");
		// Step 3:
		home.clickOnFlightSearchButton();
		Thread.sleep(3000);
		// Step 4:
		home.verifyTicketPriceOnPaymentPage();
	}
	
	@Test(description = "Enter all details and book the flight", dependsOnMethods = { "scenario3" })
	public void scenario4() throws InterruptedException {
		// Step 1:
		home.clickAndSelectFromCity("Boston");
		// Step 2:
		home.clickAndSelectToCity("London");
		// Step 3:
		home.clickOnFlightSearchButton();
		Thread.sleep(5000);
		home.verifyListOfFlightShown();
		// Step 4:
		home.chooseFirstFlightShown();
		Thread.sleep(3000);
		//Step 5:
		home.enterName();
		home.enterAddress();
		home.enterCity();
		home.enterState();
		home.enterZipCode();
		home.selectCardType();
		home.enterCCardNumber();
		home.enterCCardMonth();
		home.enterCCardYear();
		home.enterNameOnCard();
		//Step 6:
		home.clickOnPurchaseFlight();
		home.verifySuccessfulMessageAndPurchaseID();
	}
	
}
