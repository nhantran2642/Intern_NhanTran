package com.nhantran.models;

import com.nhantran.common.Constants;
import com.nhantran.utils.JsonFileReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class User {

    private String email;
    private String password;
    private String confirmPassword;
    private String pid;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(String email, String password, String confirmPassword, String pid) {
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.pid = pid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    private static User getLoginAccountFromJsonFile(String accountName) {
        JSONObject jsonObject = JsonFileReader.readJsonFromFile(Constants.ACCOUNT_JSON_FILE_PATH);
        if (jsonObject != null) {
            JSONObject accounts = (JSONObject) jsonObject.get("loginAccounts");
            JSONObject userObj = (JSONObject) ((JSONArray) accounts.get(accountName)).get(0);
            return new User((String) userObj.get("email"), (String) userObj.get("password"));
        } else {
            return null;
        }
    }

    private static User getRegisterAccountFromJsonFile(String accountName) {
        JSONObject jsonObject = JsonFileReader.readJsonFromFile(Constants.ACCOUNT_JSON_FILE_PATH);
        if (jsonObject != null) {
            JSONObject accounts = (JSONObject) jsonObject.get("registerAccounts");
            JSONObject userObj = (JSONObject) ((JSONArray) accounts.get(accountName)).get(0);
            return new User((String) userObj.get("email"), (String) userObj.get("password"), (String) userObj.get("confirmPassword"), (String) userObj.get("pid"));
        } else {
            return null;
        }
    }

    public static User getValidUser(){
        return getLoginAccountFromJsonFile("validAccount");
    }

    public static User getInvalidUser(){
        return getLoginAccountFromJsonFile("invalidAccount");
    }

    public static User getBlankEmailUser(){
        return getLoginAccountFromJsonFile("blankEmailAccount");
    }

    public static User getInactivatedUser(){
        return getLoginAccountFromJsonFile("inactivatedAccount");
    }

    public static User getAlreadyRegisteredUser(){
        return getRegisterAccountFromJsonFile("alreadyRegisteredAccount");
    }

    public static User getEmptyPasswordPidUser(){
        return getRegisterAccountFromJsonFile("emptyPasswordPidAccount");
    }
}
