package bdd.AmazonProject1;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

public class LoginPage  
{

	public  WebDriver driver;
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));

	LoginPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="ap_email_login") 
	 private WebElement mobilenumberoremail;
	
	//Getter and setter method
	 public WebElement getMobilenumberoremail() {
		return mobilenumberoremail;
	}

	public void setMobilenumberoremail(WebElement mobilenumberoremail) {
	 	this.mobilenumberoremail = mobilenumberoremail;
	}



	
	
	@FindBy(className  ="a-button-input") 
	private WebElement continuebutton;
	
	@FindBy(id="ap_password") 
	private WebElement passwordTextfield;
	
	@FindBy(id="signInSubmit") 
	private WebElement loginbutton;
	
	
	SoftAssert sa= new SoftAssert();
	
	
	
	
	
	public void username_textfield(String username) 
	{
		
		
		wait.until(ExpectedConditions.visibilityOf(mobilenumberoremail));
		
		sa.assertEquals(mobilenumberoremail.isEnabled(), true);
		mobilenumberoremail.sendKeys(username);
		Reporter.log("Mobile Number Entered");
		
	}
	
	public void clickOnContinue()
	{	
		wait.until(ExpectedConditions.elementToBeClickable(continuebutton));
		continuebutton.click();
	}
	
   public void password_textfield(String password) {
	   
		wait.until(ExpectedConditions.visibilityOf(passwordTextfield));
		
	   passwordTextfield.sendKeys(password);
	Reporter.log("Password Entered");
	
	}

    public void logintoClick() {
		wait.until(ExpectedConditions.elementToBeClickable(loginbutton));
    	loginbutton.click();
    	
    	String actualtitle=driver.getTitle();
    	String expectedtitle="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
    	
    	sa.assertEquals(actualtitle, expectedtitle);
    	Reporter.log("Succesfully Login to Amazon");
    	sa.assertAll();
}

	
    
    
    
}
