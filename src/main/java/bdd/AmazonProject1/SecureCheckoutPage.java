package bdd.AmazonProject1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

public class SecureCheckoutPage  
{

	public  WebDriver driver;
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	SoftAssert sa = new SoftAssert();

	SecureCheckoutPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	@FindBy(xpath = "(//a[@class='a-link-normal'])[1]")
	WebElement addAddress;

    
	
	
	public void addDeliveryAddress() {
		
	wait.until(ExpectedConditions.elementToBeClickable(addAddress));
	
	sa.assertEquals(addAddress.getText(), "Add delivery instructions");
	
	addAddress.click();
	
	}
    
}
