package utility;

import java.io.File;
import java.io.IOException;
import java.sql.Driver;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listernerclass   implements ITestListener {

	
 public static WebDriver driver;
	
	
	
	@Override
	public void onTestSuccess(ITestResult result) {
		
		 		//System.out.println(driver);
		ITestListener.super.onTestSuccess(result);
		
		TakesScreenshot ts= (TakesScreenshot)driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./Screenshot//PassTestCases//PassTC"+Math.random()+".png");
		try {
			FileHandler.copy(source, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
	
		ITestListener.super.onTestFailure(result);
		
		TakesScreenshot ts= (TakesScreenshot)driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./Screenshot//FailedTestCases//FailedTC"+Math.random()+".png");
		try {
			FileHandler.copy(source, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
