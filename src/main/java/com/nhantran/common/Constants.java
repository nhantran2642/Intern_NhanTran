package com.nhantran.common;

public class Constants {
    public static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final String REPORT_FILE_PATH = PROJECT_PATH + "/reports/";
    public static final String ACCOUNT_JSON_FILE_PATH = PROJECT_PATH + "/src/main/resources/userdata.json";
    public static final String RAILWAY_URL = "http://saferailway.somee.com/";
    public static final String TEMPORARY_MAIL_URL = "https://www.guerrillamail.com";
    public static final String NODE_URL = "http://localhost:4444/wd/hub";
    public static final int DRIVER_WAIT_TIME = 25;
    public static final int PAGE_LOAD_WAIT_TIME = 30;
    public static final int IMPLICITLY_WAIT_TIME = 20;
}
