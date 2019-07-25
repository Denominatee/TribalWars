package org.sikora.tw2.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtils {

    protected PropertiesUtils(){
    }

    private static final Logger LOG = LoggerFactory.getLogger(PropertiesUtils.class);

    private static PropertiesUtils instance = null;
    private static Properties properties = null;

    public static PropertiesUtils getInstance() {
        if (instance == null) {
            instance = new PropertiesUtils();
            properties = loadProperties();
            LOG.info("PropertiesUtils instance created.");
        }
        LOG.info("PropertiesUtils instance returned.");
        return instance;
    }

    public String getProperty(String key) {
        String property = properties.getProperty(key);
        LOG.info("Property retrieved: Key - " + key + "| Value - " + property);
        return property;
    }


    public void setProperty(String key, String value) {
        properties.setProperty(key, value);
        LOG.info("Property set: Key - " + key + "| Value - " + value);
        saveProperties();
    }

    public void saveProperties(){
        LOG.info("Save properties file.");
        FileOutputStream outputStream;
        try {
            outputStream = new FileOutputStream("resources/config.properties");
            properties.store(outputStream, "");
            outputStream.close();
        } catch (IOException e) {
            LOG.info("Properties file could not be save.", e.getMessage());
            e.getMessage();
        }
        LOG.info("Properties saved.");
    }

    private static Properties loadProperties(){
        properties = new Properties();
        try {
            InputStream in = getInstance().getClass().getClassLoader().getResourceAsStream("config.properties");
            if (in != null) {
                properties.load(in);
                in.close();
            }
        } catch (IOException e) {
            LOG.error("Properties file could not be loaded!" + e.getMessage());
            e.printStackTrace();
        }
        return properties;
    }
}
