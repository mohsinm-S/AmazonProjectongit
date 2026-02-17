package bdd.AmazonProject1;

import java.time.Duration;


import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import utility.BaseClass;
import utility.Listernerclass;
import utility.RetryAnalyzer;
import utility.TestDataProvider;

@Listeners(Listernerclass.class)



public class Testcase2_LoginAndlogout extends BaseClass {
	
	
	
	@Test(retryAnalyzer = RetryAnalyzer.class ,dependsOnGroups = "system"
	,dataProviderClass = TestDataProvider.class	,dataProvider = "logindata")
	
	public void logoutToAmazon(String username,String password) {
	
		LoginPage loginpage= new LoginPage(driver);
		HomePage homepage =new HomePage(driver);
		
		
		homepage.hoverovrAccountListMenu();
		homepage.signinClick();
		loginpage.username_textfield(username);
		loginpage.clickOnContinue();
		loginpage.password_textfield(password);
		loginpage.logintoClick();
		homepage.hoverovrAccountListMenu();
		homepage.clickOnlogout();
		
		
	}

}
