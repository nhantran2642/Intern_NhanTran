package com.nhantran.utils;

import com.nhantran.models.User;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class JsonFileReader {
    /**
     * Reads JSON data from a file and returns it as a JSONObject.
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
}
