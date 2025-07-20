package com.sporcle.api;

import com.sporcle.finals.Finals;
import com.sporcle.utils.PropertiesUtils;
import io.restassured.path.json.JsonPath;
import io.restassured.path.json.exception.JsonPathException;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class LogInForm extends ApiForm {
    private static final String URL_LOGIN = URL_BASE + "/auth/ajax/login.php";
    private final String set;

    public static final String INCORRECT_LOGIN_INFORMATION_ERROR_TEXT = "Incorrect login information.";
    public static final String MISSING_EMAIL_OR_PASSWORD_ERROR_TEXT = "Missing email or password";
    public static final String INCORRECT_LOGIN_INFORMATION_MESSAGE = "Incorrect login information";
    public static final String MISSING_EMAIL_MESSAGE = "Missing email or username";
    public static final String MISSING_PASSWORD_MESSAGE = "Missing password";

    public LogInForm(String propertiesFileName, String set) {
        super(propertiesFileName);
        this.set = set;
    }

    @Override
    protected Response getResponse() {
        return getResponse(URL_LOGIN, getContentTypeHeader(), getFormParams());
    }

    @Override
    protected Map<String, String> getContentTypeHeader() {
        Map<String, String> header = new HashMap<>();
        header.put("content-type", "application/x-www-form-urlencoded; charset=UTF-8");
        return header;
    }

    private Map<String, String> getFormParams() {
        Properties setProperties = PropertiesUtils.readSetPropertiesFromResource(propertiesFileName, set);
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
            return Finals.EMPTY_STRING;
        }
    }

    public String getErrorsEmailMessage() {
        Map<String, String> object = getErrorObjectByFieldValue("email");
        if (object != null) {
            return object.get("message");
        } else {
            return Finals.EMPTY_STRING;
        }
    }

    public String getErrorsPasswordField() {
        Map<String, String> object = getErrorObjectByFieldValue("password");
        if (object != null) {
            return object.get("field");
        } else {
            return Finals.EMPTY_STRING;
        }
    }

    public String getErrorsPasswordMessage() {
        Map<String, String> object = getErrorObjectByFieldValue("password");
        if (object != null) {
            return object.get("message");
        } else {
            return Finals.EMPTY_STRING;
        }
    }
}
