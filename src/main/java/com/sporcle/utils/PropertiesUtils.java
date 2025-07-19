package com.sporcle.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtils {
    public static Properties readPropertiesFromResource(String resourceName) {
        Properties properties = new Properties();

        /*try (FileInputStream fis = new FileInputStream(fileName)) {
            properties.load(fis);
        } catch (IOException e) {
            System.err.println("Ошибка при чтении properties: " + e.getMessage());
        }*/

        try (InputStream inputStream = PropertiesUtils.class.getClassLoader().getResourceAsStream(resourceName)) {
            if (inputStream == null) {
                System.err.println("Ресурс не найден: " + resourceName);
            } else {
                properties.load(inputStream);
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении properties: " + e.getMessage());
        }

        return properties;
    }

    public static Properties readSetPropertiesFromResource(String fileNameWithExtension, String set) {
        Properties allProperties = readPropertiesFromResource(fileNameWithExtension);

        Properties setProperties = new Properties();

        String setPrefix = set + ".";
        int setPrefixLength = setPrefix.length();

        for (String key : allProperties.stringPropertyNames()) {
            if (key.startsWith(setPrefix)) {
                String keyAfterRemovingSetPrefix = key.substring(setPrefixLength);
                setProperties.setProperty(keyAfterRemovingSetPrefix, allProperties.getProperty(key));
            }
        }
        return setProperties;
    }
}
