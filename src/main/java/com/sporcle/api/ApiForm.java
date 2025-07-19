package com.sporcle.api;

import com.sporcle.ui.finals.Finals;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public abstract class ApiForm {
    protected static final String URL_BASE = "https://www.sporcle.com";
    protected final String propertiesFileName;
    private static final String extension = ".properties";

    protected static final Logger logger = LogManager.getLogger();

    protected ApiForm(String propertiesFileNameWithoutExtension) {
        this.propertiesFileName = propertiesFileNameWithoutExtension + extension;
    }

    protected abstract Response getResponse();

    protected abstract Map<String, String> getContentTypeHeader();

    protected Map<String, String> getFormParams(Properties properties) {
        Map<String, String> formParams = new HashMap<>();

        String propertyByKey = Finals.EMPTY_STRING;
        for (String key : properties.stringPropertyNames()) {
            propertyByKey = properties.getProperty(key);
            formParams.put(key, propertyByKey);
            logger.info("{}: {}", key, propertyByKey);
        }
        return formParams;
    }

    protected Response getResponse(String endpoint, Map<String, String> headers, Map<String, String> formParams) {
        return given()
                .headers(headers)
                //.body("email=test%40test.xyz&passwd=7298472839432&remember=1")
                .formParams(formParams)
                .when()
                .post(endpoint);
    }

    public int getStatusCode() {
        return getResponse().getStatusCode();
    }
}
