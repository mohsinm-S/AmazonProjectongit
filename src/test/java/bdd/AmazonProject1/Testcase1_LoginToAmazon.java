package bdd.AmazonProject1;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import utility.BaseClass;
import utility.Listernerclass;
import utility.RetryAnalyzer;
import utility.TestDataProvider;

@Listeners(Listernerclass.class)


public class Testcase1_LoginToAmazon extends BaseClass {
	
	
	
	@Test(  retryAnalyzer = RetryAnalyzer.class ,	groups = {"system"}  ,dataProviderClass = TestDataProvider.class
			,dataProvider = "logindata")
	public void loginwithValidcredentials(String username,String password) {
	
		LoginPage loginpage= new LoginPage(driver);
		HomePage homepage =new HomePage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		homepage.hoverovrAccountListMenu();
		homepage.signinClick();
		loginpage.username_textfield(username);
		loginpage.clickOnContinue();
		loginpage.password_textfield(password);
		loginpage.logintoClick();
		
	
		
	}

}
