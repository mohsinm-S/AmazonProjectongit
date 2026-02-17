package utility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

	int maxcount=2;
	int initalcount=0;
	@Override
	public boolean retry(ITestResult result) {

		if(initalcount<maxcount) {
			initalcount++;
			return true;
		}

		return false;
	}

}
