package com.nhantran.utils.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.nhantran.common.Constants;
import com.nhantran.utils.helpers.DateTimeHelper;

public class ExtentReportManager {

    private static ExtentReports extentReports = new ExtentReports();
    private static String currentDateTime = DateTimeHelper.generateCurrentDateTime();

    public synchronized static ExtentReports getExtentReports() {
        ExtentSparkReporter reporter = new ExtentSparkReporter(Constants.REPORT_FILE_PATH + "railway-report-" + currentDateTime + ".html");
        extentReports.attachReporter(reporter);
        return extentReports;
    }
}
