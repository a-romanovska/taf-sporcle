package com.sporcle.utils;

import com.sporcle.enums.FileExtension;
import com.sporcle.enums.Symbol;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtils {
    private static final String configFile = "config" + FileExtension.PROPERTIES.getExtension();
    private static final String baseUrlKey = "baseUrl";
    private static final String accountsGoogleUrlKey = "accountsGoogleUrl";
    private static final String appleidAppleUrlKey = "appleidAppleUrl";
    private static Logger logger = LogManager.getLogger();

    public static Properties readPropertiesFromResource(String resourceFileName) {
        Properties properties = new Properties();

        try (InputStream inputStream = PropertiesUtils.class.getClassLoader().getResourceAsStream(resourceFileName)) {
            if (inputStream == null) {
                logger.info("Cannot find " + resourceFileName);
            } else {
                properties.load(inputStream);
            }
        } catch (IOException error) {
            logger.info("Error when trying to read: " + error.getMessage());
        }
        return properties;
    }

    public static Properties readSetFromCredentialsProperties(String fileName, String set) {
        Properties allProperties = readPropertiesFromResource(fileName);
        Properties setProperties = new Properties();

        String setPrefix = set + Symbol.DOT.getSymbol();
        int setPrefixLength = setPrefix.length();

        for (String key : allProperties.stringPropertyNames()) {
            if (key.startsWith(setPrefix)) {
                String keyAfterRemovingSetPrefix = key.substring(setPrefixLength);
                setProperties.setProperty(keyAfterRemovingSetPrefix, allProperties.getProperty(key));
            }
        }
        return setProperties;
    }

    public static String getBaseUrl() {
        return readPropertiesFromResource(configFile).getProperty(baseUrlKey);
    }

    public static String getContinueWithGoogleUrl() {
        return readPropertiesFromResource(configFile).getProperty(accountsGoogleUrlKey);
    }

    public static String getContinueWithAppleUrl() {
        return readPropertiesFromResource(configFile).getProperty(appleidAppleUrlKey);
    }
}
