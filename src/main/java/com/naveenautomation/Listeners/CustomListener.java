package com.naveenautomation.Listeners;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.naveenautomation.Base.TestBase;
import com.naveenautomation.Utils.Log;
import com.naveenautomation.Utils.Utils;

public class CustomListener extends TestBase implements ITestListener {
	
	final Logger logger = Log.getLoggerData(this.getClass().getName());

	public void onTestStart(ITestResult result) {
		logger.info("Test execution has started for : " + result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		logger.info("Test execution has passed for : " + result.getName());
	}

	public void onTestFailure(ITestResult result) {
		logger.error("Test execution failed and taking screen shot: " + result.getName());
		Utils.takeScreenShot(result.getName());
	}

	public void onTestSkipped(ITestResult result) {
		logger.info("Test execution has skipped for : " + result.getName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {
		onTestFailure(result);
	}

	public void onStart(ITestContext context) {
		// not implemented
	}

	public void onFinish(ITestContext context) {
		// not implemented
	}
}
