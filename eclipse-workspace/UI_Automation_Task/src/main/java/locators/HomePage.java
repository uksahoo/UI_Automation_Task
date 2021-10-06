package locators;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import drivercore.DriverFactory;

public class HomePage extends DriverFactory {


	@FindBy(xpath = "//*[text()='Welcome to the Simple Travel Agency!']")
	WebElement pageTitle;

	public HomePage() {
		PageFactory.initElements(driver.get(), this);
	}

	public void verifyPageTitle() {
		assertEquals(pageTitle.getText(), "Welcome to the Simple Travel Agency!");
	}
}
