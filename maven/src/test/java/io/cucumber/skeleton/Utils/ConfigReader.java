package io.cucumber.skeleton.Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    final static Properties properties;

    // Static block to initialize properties file
    static {
        try {
            FileInputStream fileInputStream = new FileInputStream("src/test/resources/config/testdata.properties");
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (IOException e)  {
            e.printStackTrace();
            throw new RuntimeException("Could not read test data properties file.");
        }
    }

    // Method to get property value by key
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}

