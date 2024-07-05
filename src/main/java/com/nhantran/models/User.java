package com.nhantran.models;

import com.nhantran.utils.file_readers.JsonFileReader;
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

    public static User getLoginAccountFromJsonFile(String accountName) {
        JSONObject userObj = JsonFileReader.readUserAccountFromFile("loginAccounts", accountName);
        return new User((String) userObj.get("email"), (String) userObj.get("password"));
    }

    public static User getRegisterAccountFromJsonFile(String accountName) {
        JSONObject userObj = JsonFileReader.readUserAccountFromFile("registerAccounts", accountName);
        return new User((String) userObj.get("email"), (String) userObj.get("password"), (String) userObj.get("confirmPassword"), (String) userObj.get("pid"));
    }
}
