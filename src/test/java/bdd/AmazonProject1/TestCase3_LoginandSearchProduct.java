package bdd.AmazonProject1;

import java.time.Duration;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utility.BaseClass;
import utility.Listernerclass;
import utility.RetryAnalyzer;
import utility.TestDataProvider;

//@Listeners(Listernerclass.class)


public class TestCase3_LoginandSearchProduct extends BaseClass {
	
	
	@Test(retryAnalyzer = RetryAnalyzer.class ,groups = {"smoke"} ,
			
		dataProviderClass = TestDataProvider.class	,dataProvider = "searchproductsdata")
	
	public void searchProduct(String username,String password ,String searchItem ,
		String productIndex) throws InterruptedException {
		
		
		LoginPage loginpage= new LoginPage(driver);
		HomePage homepage =new HomePage(driver);
		
		homepage.hoverovrAccountListMenu();
		homepage.signinClick();
		loginpage.username_textfield(username);
		loginpage.clickOnContinue();
		loginpage.password_textfield(password);
		loginpage.logintoClick();
			
		homepage.searchingProduct(searchItem);
		homepage.productList(productIndex);
		
	}
	

}
