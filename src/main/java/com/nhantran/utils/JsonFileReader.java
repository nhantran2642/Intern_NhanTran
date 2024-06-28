package com.nhantran.utils;

import com.nhantran.common.Constants;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class JsonFileReader {
    /**
     * Reads JSON data from a file and returns it as a JSONObject.
     *
     * @param filePath the path to the JSON file
     * @return the parsed JSONObject
     */
    public static JSONObject readJsonFromFile(String filePath) {
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader(filePath)) {
            Object obj = parser.parse(reader);
            return (JSONObject) obj;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Reads a user's account data from a JSON file.
     *
     * @param accountType the type of account ("loginAccounts" or "registerAccounts")
     * @param accountName the name of the account
     * @return the JSONObject representing the user's account data
     */
    public static JSONObject readUserAccountFromFile(String accountType, String accountName) {
        JSONObject jsonObject = readJsonFromFile(Constants.ACCOUNT_JSON_FILE_PATH);
        if (jsonObject != null) {
            JSONObject accounts = (JSONObject) jsonObject.get(accountType);
            return (JSONObject) ((JSONArray) accounts.get(accountName)).get(0);
        } else {
            throw new NullPointerException("Cannot find or read data from " + Constants.ACCOUNT_JSON_FILE_PATH);
        }
    }
}
