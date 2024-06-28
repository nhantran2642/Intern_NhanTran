package com.nhantran.listeners;

import com.aventstack.extentreports.Status;
import com.nhantran.utils.logs.Log;
import com.nhantran.utils.reports.ExtentReportManager;
import com.nhantran.utils.reports.ExtentTestManager;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    public String getTestName(ITestResult result) {
        if (result.getTestName() != null)
            return result.getTestName();
        else
            return result.getMethod().getMethodName();
    }

    public String getTestDescription(ITestResult result) {
        if (result.getMethod().getDescription() != null)
            return result.getMethod().getDescription();
        else
            return getTestName(result);
    }

    @Override
    public void onStart(ITestContext result) {
        Log.info("Start testing " + result.getName());
    }

    @Override
    public void onFinish(ITestContext result) {
        Log.info("End testing " + result.getName());
        ExtentReportManager.getExtentReports().flush();
    }

    @Override
    public void onTestStart(ITestResult result) {
        Log.info("Running test case " + result.getName());
        ExtentTestManager.saveToReport(getTestName(result), getTestDescription(result));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Log.info("Test case " + result.getName() + " is passed.");
        ExtentTestManager.logMessage(Status.PASS, result.getName() + " is passed.");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Log.error("Test case " + result.getName() + " is failed.");
        //CaptureHelper.captureScreenshot(result.getName());
        Log.error(result.getThrowable().toString());
        ExtentTestManager.addScreenshot(result.getName());
        ExtentTestManager.logMessage(Status.FAIL, result.getThrowable().toString());
        ExtentTestManager.logMessage(Status.FAIL, result.getName() + " is failed.");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        Log.error("Test case " + result.getName() + " is skipped.");
        Log.error(result.getThrowable().toString());

        //Extent Report
        ExtentTestManager.logMessage(Status.SKIP, result.getThrowable().toString());
    }

}
