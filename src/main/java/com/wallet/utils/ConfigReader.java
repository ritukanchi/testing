package com.wallet.utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static final Properties properties = new Properties();

    static {
        try (InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new RuntimeException("config.properties not found in resources!");
            }
            properties.load(input);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load config.properties file", e);
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}