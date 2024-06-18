package com.nhantran.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileReader {
    private Properties properties;

    public PropertiesFileReader(String propertyFilePath) {
        properties = new Properties();
        try (FileInputStream fis = new FileInputStream(propertyFilePath)) {
            properties.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Property file not found: " + propertyFilePath);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO Exception while loading property file: " + propertyFilePath);
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
