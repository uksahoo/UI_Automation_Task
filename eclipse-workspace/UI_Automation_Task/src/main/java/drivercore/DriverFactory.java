package drivercore;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class DriverFactory {
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	//private String xmlTestName;

	@Parameters("browser")
	@BeforeClass

	/**
	 * This method will get the driver based on the browser name
	 * 
	 * @param browser
	 * @param execution
	 * @param tst
	 */
	public WebDriver getDriverFor(String browser) {
		// xmlTestName = tst.getName();
		try {
			if (browser.equalsIgnoreCase("chrome")) {

				System.setProperty("webdriver.chrome.driver", "Resources//drivers//chromedriver.exe");
				driver.set(new ChromeDriver());

			} else if (browser.equalsIgnoreCase("edge")) {

				System.setProperty("webdriver.edge.driver", "Resources//drivers//msedgedriver.exe");
				driver.set(new EdgeDriver());

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return driver.get();
	}

	@BeforeMethod

	/**
	 * This method will get invoke the application
	 * 
	 * @param method
	 */

	public void invokeApplication(Method method) {
		try {
			driver.get().get("http://blazedemo.com/");
			driver.get().manage().window().maximize();
			driver.get().manage().deleteAllCookies();
			driver.get().manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			driver.get().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method will flush out the extent reports after class
	 */
	@AfterClass
	public void closeClassReport() {
		driver.get().quit();
	}

}
