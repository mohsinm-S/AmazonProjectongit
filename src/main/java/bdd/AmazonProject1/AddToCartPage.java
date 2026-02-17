package bdd.AmazonProject1;

import java.beans.ExceptionListener;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;



public class AddToCartPage {
	
	public  WebDriver driver;
	
	FluentWait<WebDriver> wait= new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10))
			.pollingEvery(Duration.ofSeconds(1)).ignoring(Exception.class);
			
	
	public AddToCartPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	@FindBy(xpath="//a[@id='nav-cart']")
	WebElement cartNavigation;
		
	
	@FindBy(partialLinkText = "Deselect all items")
	WebElement assertdeselectAllitemsLink;
	
	@FindBy(xpath = "//div[@class='a-declarative']/child::span[@data-a-selector='value']")
	List<WebElement> itemcount;
	
	
	@FindBy(xpath = "//button[@data-a-selector='decrement']")
	List<WebElement> removetheItems;
	
	@FindBy(xpath = "//button[@data-a-selector='increment']")
	List<WebElement> increasetheItems;
	
	@FindBy(xpath = "//input[@name='proceedToRetailCheckout']")
	WebElement checkout;
	
	
	
	SoftAssert sa= new SoftAssert();
	
	
	public void navigateToAddtoCart() {
		wait.until(ExpectedConditions.elementToBeClickable(cartNavigation));
		
		cartNavigation.click();
	
		sa.assertEquals(driver.getCurrentUrl().contains("nav_cart"), true);
		sa.assertAll();
		
	}
	
	public void chekingItemAvailbilityOnAddToCart() {
		
		
		
		if(assertdeselectAllitemsLink.isDisplayed()) {
			
			
			
			sa.assertEquals(assertdeselectAllitemsLink.isDisplayed(), true);
			Reporter.log("Items are  available in cart page");
			sa.assertAll();
				
		}else {
			
			Assert.assertTrue(false);
		}
		
		
	}
	
	
	
	
	   public void decreaseQuantity(String quntity)  {
		   
		   
	    	 
	    	  
  	     int index=0;
  	  
  	         for(WebElement count: itemcount) {
  	    
  	     
		    	if(count.getText().equals(quntity)) {
				
				for(int i=0;i<1;i++) {
					removetheItems.get(index).click();
					
				}
					
			}
			
			index++;
				
			}
		
					   
		
	   }
	   
	   
      public void increaseQuantity(String quntity) 
      {
    	    
    	     int index=0;
    	  
    	  for(WebElement count: itemcount) {
    	    
    	     
  			if(count.getText().equals(quntity)) {
  				
  				for(int i=0;i<1;i++) {
  					increasetheItems.get(index).click();
  					
  				}
  					
  			}
  			index++;
  				
  			}
		
       	}
	
	
      public void clickOnCheckoutbtn() {
    	  
    	  wait.until(ExpectedConditions.elementToBeClickable(checkout));
    	  
    	  checkout.click();
    	  
      }
      

}
     
