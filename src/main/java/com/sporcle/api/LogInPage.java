package com.sporcle.api;

import com.sporcle.Constants;
import com.sporcle.api.finals.Endpoints;
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
        header.put("content-type", "application/x-www-form-urlencoded; charset=UTF-8");
        return header;
    }

    @Override
    protected Map<String, String> getFormParams() {
        Properties setProperties = PropertiesUtils.readSetPropertiesFromResource(propertiesFileName, credentialsSet);
        if (setProperties.isEmpty()) {
            logger.info("No properties were read from file");
        }
        return super.getFormParams(setProperties);
    }

    public String getErrorText() {
        return getResponse().path("error_text");
    }

    //п если ошибка будет только для одно параметра? пароля или пояты? как найти по индексу
    public Map<String, String> getErrorObjectByFieldValue(String targetFieldValue) {
        JsonPath jsonPath = new JsonPath(getResponse().asString());

        try {
            List<Map<String, String>> errors = jsonPath.getList("errors");

            for (Map<String, String> error : errors) {
                if (targetFieldValue.equals(String.valueOf(error.get("field")))) {
                    return error;
                }
            }
        } catch (JsonPathException jsonPathException) {
            return null;
        }
        return null;
    }

    public String getErrorsEmailField() {
        Map<String, String> object = getErrorObjectByFieldValue("email");
        if (object != null) {
            return object.get("field");//не имеет смысла, тк заранее знаем что field==email
        } else {
            return Constants.EMPTY_VALUE;
        }
    }

    public String getErrorsEmailMessage() {
        Map<String, String> object = getErrorObjectByFieldValue("email");
        if (object != null) {
            return object.get("message");
        } else {
            return Constants.EMPTY_VALUE;
        }
    }

    public String getErrorsPasswordField() {
        Map<String, String> object = getErrorObjectByFieldValue("password");
        if (object != null) {
            return object.get("field");
        } else {
            return Constants.EMPTY_VALUE;
        }
    }

    public String getErrorsPasswordMessage() {
        Map<String, String> object = getErrorObjectByFieldValue("password");
        if (object != null) {
            return object.get("message");
        } else {
            return Constants.EMPTY_VALUE;
        }
    }
}
