package com.sporcle.api;

import io.restassured.path.json.JsonPath;
import io.restassured.path.json.exception.JsonPathException;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class LogInModal {
    private final String email;
    private final String password;
    private final boolean allFieldsAreFilled;

    private static final String URL_BASE = "https://www.sporcle.com";
    private static final String URL_LOGIN = URL_BASE + "/auth/ajax/login.php";

    public LogInModal(String email, String password, boolean allFieldsAreFilled) {
        this.email = email;
        this.password = password;
        this.allFieldsAreFilled = allFieldsAreFilled;
    }

    private Response getResponse() {
        return getResponse(URL_LOGIN, getContentTypeHeader(), getFormParams(email, password, allFieldsAreFilled));
    }

    private Response getResponse(String endpoint, Map<String, String> headers, Map<String, String> formParams) {
        return given()
                .headers(headers)
                //.body("email=test%40test.xyz&passwd=7298472839432&remember=1")
                .formParams(formParams)
                .when()
                .post(endpoint);
    }

    private Map<String, String> getContentTypeHeader() {
        Map<String, String> header = new HashMap<>();
        header.put("content-type", "application/x-www-form-urlencoded; charset=UTF-8");
        return header;
    }

    private Map<String, String> getFormParams(String email, String password, boolean allFieldsAreFilled) {
        Map<String, String> formParams = new HashMap<>();
        formParams.put("email", email);
        formParams.put("passwd", password);
        //formParams.put("remember", "1");
        if (allFieldsAreFilled)
            formParams.put("remember", "1");
        else
            formParams.put("remember", "0");
        return formParams;
    }

    public int getStatusCode() {
        return getResponse().getStatusCode();
    }

    public String getErrorText() {
        return getResponse().path("error_text");
    }

    //п если ошибка будет только для одно параметра? пароля или пояты? как найти по индексу
    public Map<String, String> getErrorObjectByFieldValue(String targetFieldValue) {
        //System.out.println("В getErrorsObjectByFieldValue()");
        JsonPath jsonPath = new JsonPath(getResponse().asString());
        //System.out.println("JSON\n"+getResponse().asString());

        try {

            List<Map<String, String>> errors = jsonPath.getList("errors");

            for (Map<String, String> error : errors) {
                if (targetFieldValue.equals(String.valueOf(error.get("field")))) {
                    //System.out.println("Нашли: "+error.toString());
                    return error;
                }
                //System.out.println("Скип объекта");
            }
        } catch (JsonPathException jsonPathException) {
            return null;
        }
        //System.out.println("Не нашли");
        return null;
    }

    public String getErrorsEmailField() {
        //return getResponse().path("errors[0].field");
        //return getErrorsObjectField(0);
        //System.out.println("В getErrorsEmailField()");

        Map<String, String> object = getErrorObjectByFieldValue("email");
        if (object != null)
            return object.get("field");//не имеет смысла, тк заранее знаем что field==email
        else
            return "";
    }

    public String getErrorsEmailMessage() {
        //return getResponse().path("errors[0].message");
        //return getErrorsObjectMessage(0);
        //System.out.println("В getErrorsEmailMessage()");

        Map<String, String> object = getErrorObjectByFieldValue("email");
        if (object != null)
            return object.get("message");
        else
            return "";
    }

    public String getErrorsPasswordField() {
        //return getResponse().path("errors[1].field");
        //return getErrorsObjectField(1);
        Map<String, String> object = getErrorObjectByFieldValue("password");
        if (object != null)
            return object.get("field");
        else
            return "";
    }

    public String getErrorsPasswordMessage() {
        //return getResponse().path("errors[1].message");
        //return getErrorsObjectMessage(1);

        Map<String, String> object = getErrorObjectByFieldValue("password");
        if (object != null)
            return object.get("message");
        else
            return "";
    }

    public static class ErrorTexts{
        public static final String INCORRECT_LOGIN_INFORMATION_ERROR_TEXT = "Incorrect login information.";
        public static final String MISSING_EMAIL_OR_PASSWORD_ERROR_TEXT = "Missing email or password";
        public static final String INCORRECT_LOGIN_INFORMATION_MESSAGE = "Incorrect login information";
        public static final String MISSING_EMAIL_MESSAGE = "Missing email or username";
        public static final String MISSING_PASSWORD_MESSAGE = "Missing password";
    }
}
