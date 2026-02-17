package bdd.AmazonProject1;

import java.time.Duration;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import utility.BaseClass;
import utility.Listernerclass;
import utility.RetryAnalyzer;
import utility.TestDataProvider;

@Listeners(Listernerclass.class)

public class TestCase7_LoginAndIncreaseCartItems extends BaseClass {
	
	
	@Test(dataProviderClass = TestDataProvider.class	,dataProvider = "addToCartData")
	public void addedCartItem(String username,String password ,String searchItem ,String quntity,
			String productIndex) throws InterruptedException {
		
		
		LoginPage loginpage= new LoginPage(driver);
		HomePage homepage =new HomePage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Reporter.log("Browser Launched");
		homepage.hoverovrAccountListMenu();
		homepage.signinClick();
		loginpage.username_textfield(username);
		loginpage.clickOnContinue();
		loginpage.password_textfield(password);
		loginpage.logintoClick();
			
		homepage.searchingProduct(searchItem);
		homepage.productList(productIndex);
		homepage.selectQuanityfromdropdown(quntity);
		homepage.clickOnaddtoCart();
		homepage.assertionOnAddtoCart();
		
		AddToCartPage addtocartpage =new AddToCartPage(driver);
		
		addtocartpage.navigateToAddtoCart();
		addtocartpage.chekingItemAvailbilityOnAddToCart();
	    addtocartpage.increaseQuantity(quntity);
		
		
	}
	
	

}
