package bdd.AmazonProject1;


import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

public class HomePage {
	
	WebDriver driver;
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));

	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	

	@FindBy(xpath = "//div[@id='nav-link-accountList']")
	WebElement clickonAccountList;
	
	@FindBy(xpath = "//span[@class='nav-action-inner']")
	WebElement signinbtn;
	
	
	@FindBy(xpath = "//a[@id='nav-item-signout']")
	WebElement logoutlink;
	
     @FindBy(id = "twotabsearchtextbox")
	 WebElement searchbox;
	
     @FindBy(xpath = "//a[@class='a-link-normal s-no-outline']")
     List<WebElement>  searchList; 
	
    // Add to cart button  
     @FindBy(xpath = "//input[@name='submit.add-to-cart']")
     WebElement addToCartbutton;
     
     
     // Verify the item added to cart
     
     @FindBy(xpath = "//div[@id='NATC_SMART_WAGON_CONF_MSG_SUCCESS']/child::h1")
     WebElement verifyItemAddedtoCard;
     
     // Quantity dropdown
     
     @FindBy(xpath = "//select[@name='quantity']")
     WebElement QuantityDropDown;
     
     
     // Amazon MenuItems 
     @FindBy(xpath = "//ul[@class='nav-ul']/li")
     List<WebElement> allMenuItems ;
     
     //category 
     @FindBy(xpath = "//a[@class='a-color-base a-link-normal']")
     List<WebElement> Categories ;
     
     
     //Category List
     @FindBy(xpath = "//a[@class='a-link-normal s-no-outline']")
     List<WebElement> categorylist ;
     
	
	SoftAssert sa= new SoftAssert();
	
	
	public void hoverovrAccountListMenu() {
		
	wait.until(ExpectedConditions.visibilityOf(clickonAccountList))	;
		Actions action = new Actions(driver);
		action.moveToElement(clickonAccountList).perform();
		
			
		}
		
		public void signinClick() {
			wait.until(ExpectedConditions.elementToBeClickable(signinbtn))	;

			signinbtn.click();
			
		}
	
		public void clickOnlogout() {
			wait.until(ExpectedConditions.elementToBeClickable(logoutlink))	;

			logoutlink.click();
			
			LoginPage loginpage=new LoginPage(driver);

			sa.assertEquals(loginpage.getMobilenumberoremail().isEnabled(), true);
			
			sa.assertAll();
			
			
		}
		
		public void searchingProduct(String searchItem) {
			
			wait.until(ExpectedConditions.visibilityOf(searchbox))	;
			
			searchbox.sendKeys(searchItem +Keys.ENTER);
			
			sa.assertEquals(searchList.size()>10, true);
		
			Reporter.log("All items are displayed");
			sa.assertAll();
				
			
		}
		
		
		public void productList(String productIndex) 
         {
			
			wait.until(ExpectedConditions.visibilityOfAllElements(searchbox));
			
			int indexs=Integer.parseInt(productIndex);
			searchList.get(indexs).click();
			
			Set<String> allWindows=driver.getWindowHandles();
			
			Iterator<String> it= allWindows.iterator();
			
			String parent=it.next();
			String child=it.next();
			
			driver.switchTo().window(child);
		
			
		}
		
		public void selectQuanityfromdropdown(String quntity) {
			
		wait.until(ExpectedConditions.visibilityOf(QuantityDropDown));
		
			
			if (driver.findElements(By.xpath("//select[@name='quantity']")).size() > 0) {

		        Select select = new Select(QuantityDropDown);
		        select.selectByVisibleText(quntity);

		    } else {
		        Reporter.log("Quantity dropdown is not available");
		    }
			
		}
		
		public void clickOnaddtoCart() 
		{
			sa.assertTrue(addToCartbutton.isDisplayed());
			
			wait.until(ExpectedConditions.visibilityOf(addToCartbutton));
			
			if(addToCartbutton.isDisplayed()) {
			
			addToCartbutton.click();
			
			Reporter.log("Clicked on Add to cart button");
			
			}else {
			 Reporter.log("Add to cart button not exist");
			}
		
			
		}
		
		public void assertionOnAddtoCart() 
		{
			wait.until(ExpectedConditions.visibilityOf(verifyItemAddedtoCard));
			sa.assertEquals(verifyItemAddedtoCard.getText(), "Added to cart");
			
			
			
		}

		
		
		// Select Meni Item 
		
		public void clickOnProducstmenu(String menuitem) throws InterruptedException
		{
			
		for(WebElement menu: allMenuItems) 
		{
						
			if(menu.getText().equalsIgnoreCase(menuitem)) 
			{
				
				menu.click();
				String title= driver.getTitle();
				sa.assertTrue(title.contains(menuitem));
				sa.assertAll();
				break;
			
			}
			
			
		 } 	 }

	
		// categories method
		
		 public void selectCategries(String Category) {
			 
			 for(WebElement category: Categories) {
				 
				 if(category.getText().equalsIgnoreCase(Category)) {
					 
					 category.click();
					 break;
					 
				 }
				 				 
			 }		 }
		
	// category list of items 
		 
		 public void categoryList() {
			 
			 sa.assertTrue(categorylist.size()>0);
			 sa.assertAll(null);
			 
			 categorylist.get(0).click(); 
			 
			
			 
		}
		 
		 
}
