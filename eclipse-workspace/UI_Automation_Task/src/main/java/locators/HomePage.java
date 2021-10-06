package locators;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import drivercore.DriverFactory;

public class HomePage extends DriverFactory {


	@FindBy(xpath = "//*[text()='Welcome to the Simple Travel Agency!']")
	WebElement pageTitle;
	
	@FindBy(xpath = "//select[@name='fromPort']")
	WebElement fromCity;
	
	@FindBy(xpath = "//select[@name='toPort']")
	WebElement toCity;
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement flightSearchButton;

	public HomePage() {
		PageFactory.initElements(driver.get(), this);
	}

	public void verifyPageTitle() {
		assertTrue(pageTitle.getText().equals("Welcome to the Simple Travel Agency!"));
	}
	
	public void verifyFromCityDisplayedAndEnabled() {
		assertTrue(fromCity.isDisplayed());
		assertTrue(fromCity.isEnabled());
	}
	
	public void clickAndSelectFromCity(String fCity) {
		Select selectFromCity = new Select(fromCity);
		fromCity.click();
		selectFromCity.selectByVisibleText(fCity);
	}
	
	public void verifyToCityDisplayedAndEnabled() {
		assertTrue(toCity.isDisplayed());
		assertTrue(toCity.isEnabled());
	}
	
	public void clickAndSelectToCity(String tCity) {
		Select selectFromCity = new Select(toCity);
		toCity.click();
		selectFromCity.selectByVisibleText(tCity);
	}
	
	public void clickOnFlightSearchButton() {
		flightSearchButton.click();
	}
	
	public void verifyListOfFlightShown() {
		assertTrue(driver.get().findElements(By.xpath("//input[@value='Choose This Flight']")).size()> 0);
	}
	
	
}
