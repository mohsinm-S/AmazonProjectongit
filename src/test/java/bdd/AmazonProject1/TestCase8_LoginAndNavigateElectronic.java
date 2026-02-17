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

public class TestCase8_LoginAndNavigateElectronic extends BaseClass {
	
	
	@Test( dataProviderClass = TestDataProvider.class	,dataProvider = "ProductsData" )
	public void searchElectronics(String username,String password ,String menuitem ,String Category
			) throws InterruptedException {
		
		
		LoginPage loginpage= new LoginPage(driver);
		HomePage homepage =new HomePage(driver);
		
		Reporter.log("Browser Launched");
		homepage.hoverovrAccountListMenu();
		homepage.signinClick();
		loginpage.username_textfield(username);
		loginpage.clickOnContinue();
		loginpage.password_textfield(password);
		loginpage.logintoClick();
		homepage.clickOnProducstmenu(menuitem);
		homepage.selectCategries(Category);
		homepage.categoryList();
		
		
	}
	
	

}
