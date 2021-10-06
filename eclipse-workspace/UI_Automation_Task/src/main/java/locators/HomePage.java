package locators;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage {

	WebDriver driver;

	@FindBy(xpath = "//*[text()='Welcome to the Simple Travel Agency!']")
	WebElement pageTitle;

	@FindBy(xpath = "//select[@name='fromPort']")
	WebElement fromCity;

	@FindBy(xpath = "//select[@name='toPort']")
	WebElement toCity;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement flightSearchButton;

	@FindBy(xpath = "//*[contains(text(),'Price')]")
	WebElement flightPricePaymentPage;

	@FindBy(id = "inputName")
	WebElement name;

	@FindBy(id = "address")
	WebElement address;

	@FindBy(id = "city")
	WebElement city;

	@FindBy(id = "state")
	WebElement state;

	@FindBy(id = "zipCode")
	WebElement zipCode;

	@FindBy(id = "cardType")
	WebElement cardType;

	@FindBy(id = "creditCardNumber")
	WebElement creditCardNumber;

	@FindBy(id = "creditCardMonth")
	WebElement creditCardMonth;

	@FindBy(id = "creditCardMonth")
	WebElement creditCardYear;

	@FindBy(id = "nameOnCard")
	WebElement nameOnCard;

	@FindBy(xpath = "//input[@value='Purchase Flight']")
	WebElement purchaseFlight;

	@FindBy(xpath = "//*[text()='Thank you for your purchase today!']")
	WebElement successfulMessage;

	@FindBy(xpath = "*//table/tbody/tr[1]/td[2]")
	WebElement purchaseID;

	private List<WebElement> getFlightList() {
		List<WebElement> flightList = null;
		try {
			flightList = driver.findElements(By.xpath("//input[@value='Choose This Flight']"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return flightList;
	}

	private List<WebElement> getFlightPrice() {
		List<WebElement> flightPrice = null;
		try {
			flightPrice = driver.findElements(By.xpath("//input[@name='price']"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return flightPrice;
	}

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void verifyPageTitle() {
		try {
			assertTrue(pageTitle.getText().equals("Welcome to the Simple Travel Agency!"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void verifyFromCityDisplayedAndEnabled() {
		try {
			assertTrue(fromCity.isDisplayed());
			assertTrue(fromCity.isEnabled());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void clickAndSelectFromCity(String fCity) {
		try {
			Select selectFromCity = new Select(fromCity);
			fromCity.click();
			selectFromCity.selectByVisibleText(fCity);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void verifyToCityDisplayedAndEnabled() {
		try {
			assertTrue(toCity.isDisplayed());
			assertTrue(toCity.isEnabled());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void clickAndSelectToCity(String tCity) {
		try {
			Select selectFromCity = new Select(toCity);
			toCity.click();
			selectFromCity.selectByVisibleText(tCity);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void clickOnFlightSearchButton() {
		try {
			flightSearchButton.click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void verifyListOfFlightShown() {
		try {
			assertTrue(getFlightList().size() > 0);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void chooseFirstFlightShown() {
		try {
			getFlightList().get(0).click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void verifyTicketPriceOnPaymentPage() {
		try {
			Float FP1 = Float.valueOf(getFlightPrice().get(0).getAttribute("value"));
			chooseFirstFlightShown();
			Float FP2 = Float.valueOf((flightPricePaymentPage.getText().split(":"))[1]);
			assertEquals(FP2, FP1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void enterName() {
		try {
			name.click();
			name.sendKeys("UKSahoo");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void enterAddress() {
		try {
			address.click();
			address.sendKeys("Hyderabad");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void enterCity() {
		try {
			city.click();
			city.sendKeys("Hyderabad");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void enterState() {
		try {
			state.click();
			state.sendKeys("Telangana");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void enterZipCode() {
		try {
			zipCode.click();
			zipCode.sendKeys("123456");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void selectCardType() {
		try {
			Select selectCardType = new Select(cardType);
			cardType.click();
			selectCardType.selectByVisibleText("American Express");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void enterCCardNumber() {
		try {
			creditCardNumber.click();
			creditCardNumber.sendKeys("12345678645");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void enterCCardMonth() {
		try {
			creditCardMonth.click();
			creditCardMonth.sendKeys("12");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void enterCCardYear() {
		try {
			creditCardYear.click();
			creditCardYear.sendKeys("2021");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void enterNameOnCard() {
		try {
			nameOnCard.click();
			nameOnCard.sendKeys("UKSahoo");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void clickOnPurchaseFlight() {
		try {
			purchaseFlight.click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void verifySuccessfulMessageAndPurchaseID() {
		try {
			assertTrue(successfulMessage.isDisplayed());
			assertTrue(!purchaseID.getText().isEmpty());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
