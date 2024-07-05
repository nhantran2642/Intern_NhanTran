package com.nhantran.listeners;

import com.nhantran.common.Constants;
import com.nhantran.utils.file_readers.PropertiesFileReader;
import org.testng.IAlterSuiteListener;
import org.testng.xml.XmlSuite;

import java.util.List;

public class CustomSuiteListener implements IAlterSuiteListener {
    @Override
    public void alter(List<XmlSuite> suites) {
        PropertiesFileReader prop = new PropertiesFileReader(Constants.CONFIG_FILE_PATH);
        String runMode = prop.getProperty("runMode");
        String browser = prop.getProperty("browser");

        for (XmlSuite suite: suites) {
            suite.getParameters().put("runMode", runMode);
            suite.setParallel(XmlSuite.ParallelMode.TESTS);
            suite.setThreadCount(5);
            suite.getTests().forEach(test -> test.getLocalParameters().put("browser", browser));
        }
    }
}
