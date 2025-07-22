package com.sporcle.api.finals;

import com.sporcle.utils.PropertiesUtils;

public class Endpoints {
    public static final String BASE_URL = PropertiesUtils.getBaseUrl();
    public static final String LOGIN = BASE_URL + "/auth/ajax/login.php";
    public static final String SEARCH = BASE_URL + "/search/";
}
