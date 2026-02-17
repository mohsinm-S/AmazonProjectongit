package utility;

import org.openqa.selenium.WebDriver;

public class DriverFactory {
	
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	
	
	public static void setDriver(WebDriver driver2) {
		driver.set(driver2);
	}

	public static WebDriver getDriver() {
		
		return driver.get();
	}
	
	

}
