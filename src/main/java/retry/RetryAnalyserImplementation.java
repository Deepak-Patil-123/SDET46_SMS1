package retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * This class is used for if any test script get failed during execution then by using this class method it will execute for multiple times.
 * @author Deepak
 *
 */
public class RetryAnalyserImplementation implements IRetryAnalyzer{

	int count;
	@Override
	public boolean retry(ITestResult result) {

		int exCount=0;
		if(count<exCount) {
			count++;
		return true;
		}
		return false;
	}

}
