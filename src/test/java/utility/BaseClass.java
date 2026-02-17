package utility;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;



public class BaseClass extends Listernerclass

{
	
	
	@BeforeMethod(alwaysRun = true)
	@Parameters({"browser" ,"url"})
	
	public void launchbrowser(String browser ,String url) {
		
	switch(browser) {
	
	case "chrome":  
		
		
		ChromeOptions option =new ChromeOptions();
		option.addArguments("start-maximized");
		
		
		driver= new ChromeDriver(option);
		
		//DriverFactory.setDriver(driver);
	
		
		
		
		
		
		//Assert.assertEquals("", "//h4[text()='Click the button below to continue shopping']");
		
		break;
		
	case "firfox": 
		FirefoxOptions option1 =new FirefoxOptions();
		
		option1.addArguments("start-maximized");
		
		driver=new FirefoxDriver(option1);
		
		
		
		break;

	case "edge" : 
		
		EdgeOptions option2= new EdgeOptions();
		option2.addArguments("start-maximized");
		driver=new EdgeDriver(option2);
		
		//DriverFactory.setDriver(driver);
		
		
		break;
		
	default : 
		ChromeOptions option3 =new ChromeOptions();
		option3.addArguments("start-maximized");
		
		driver=new ChromeDriver(option3);
		
		
		break;
	}
		
	driver.manage().deleteAllCookies();
	driver.get(url);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
	
	
	WebElement ele= driver.findElement(By.xpath("//h4[text()='Click the button below to continue shopping']"));
	
	String text=ele.getText();
	
	if(text.equalsIgnoreCase("Click the button below to continue shopping")) {
		
		driver.findElement(By.xpath("//button[@class='a-button-text']")).click();
	}
	
	
		
		
	}
	
	@AfterMethod(alwaysRun = true)
	public void quitbrowser() {
		
		driver.quit();
	
	}

}
