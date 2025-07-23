package com.sporcle.api.pages;

import com.sporcle.api.Endpoints;
import com.sporcle.enums.Symbol;
import com.sporcle.utils.PropertiesUtils;
import io.restassured.path.json.JsonPath;
import io.restassured.path.json.exception.JsonPathException;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class LogInPage extends BasePage {
    private final String credentialsSet;
    private final String contentTypeKey = "content-type";
    private final String contentTypeValue = "application/x-www-form-urlencoded; charset=UTF-8";
    private final String errorsArrayPath = "errors";
    private final String fieldKey = "field";
    private final String emailValue = "email";
    private final String passwordValue = "password";
    private final String messageKey = "message";
    private final String errorTextPath = "error_text";

    public LogInPage(String propertiesFileName, String credentialsSet) {
        super(Endpoints.LOGIN, propertiesFileName);
        this.credentialsSet = credentialsSet;
    }

    @Override
    protected Response getResponse() {
        return getResponse(URL, getContentTypeHeader(), getFormParams());
    }

    @Override
    protected Map<String, String> getContentTypeHeader() {
        Map<String, String> header = new HashMap<>();
        header.put(contentTypeKey, contentTypeValue);
        return header;
    }

    @Override
    protected Map<String, String> getFormParams() {
        Properties setProperties = PropertiesUtils.readSetFromCredentialsProperties(propertiesFileName, credentialsSet);
        if (setProperties.isEmpty()) {
            logger.info("No properties were read from file");
        }
        return super.getFormParams(setProperties);
    }

    public String getErrorText() {
        return getResponse().path(errorTextPath);
    }

    public String getErrorMessageForEmail() {
        return getErrorMessageFor(emailValue);
    }

    public String getErrorMessageForPassword() {
        return getErrorMessageFor(passwordValue);
    }

    private String getErrorMessageFor(String fieldValue) {
        Map<String, String> errorElement = getErrorElementByFieldValue(fieldValue);
        if (errorElement != null) {
            return errorElement.get(messageKey);
        } else {
            return Symbol.EMPTY.getSymbol();
        }
    }

    public Map<String, String> getErrorElementByFieldValue(String targetFieldValue) {
        JsonPath responseJsonPath = new JsonPath(getResponse().asString());

        String currentFieldValue;
        try {
            List<Map<String, String>> errors = responseJsonPath.getList(errorsArrayPath);
            for (Map<String, String> error : errors) {
                currentFieldValue = String.valueOf(error.get(fieldKey));
                if (currentFieldValue.equals(targetFieldValue)) {
                    return error;
                }
            }
        } catch (JsonPathException jsonPathException) {
            return null;
        }
        logger.info("No such targetFieldValue was found");
        return null;
    }
}
