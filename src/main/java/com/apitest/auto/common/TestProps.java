package com.apitest.auto.common;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class TestProps {
    private static String CONFIG_FILE = "/TestProps.properties";
    private static TestProps instance;
    Properties properties;

    public static TestProps instance() {
        if (instance == null) {
            instance = new TestProps();
        }
        return instance;
    }

    private TestProps() {
        try {
            Properties p = new Properties();
            InputStream is = this.getClass().getResourceAsStream(CONFIG_FILE);
            if (is != null) {
                InputStreamReader isr = new InputStreamReader(is, "UTF-8");

                p.load(isr);
                is.close();
            }

            properties = p;

        } catch (Exception e) {
            System.err.println("Failed to initialize TestProps");
            e.printStackTrace();
        }
    }

    public static String get(final String propertyName) {
        return (instance().getProperty(propertyName));
    }

    String getProperty(final String propertyName) {
        return properties.getProperty(propertyName);
    }

    void setProperty(String key, String propertyName) {
        properties.setProperty(key, propertyName);
    }


}
