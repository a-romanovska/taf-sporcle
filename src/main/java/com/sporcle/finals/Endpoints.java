package com.sporcle.finals;

import com.sporcle.utils.PropertiesUtils;

public class Endpoints {
    public static final String BASE_URL = PropertiesUtils.getBaseUrl();
    public static final String HOME = BASE_URL + "/";
    public static final String EVENTS = BASE_URL + "/events/";
    public static final String QUIZ_CREATION = BASE_URL + "/create/";
    public static final String COMMUNITY = BASE_URL + "/groups/";
    public static final String VIDEOS = BASE_URL + "/videos/";
    public static final String PRIVATE_EVENTS = EVENTS + "private-events/";
    public static final String REMOVE_ADS = BASE_URL + "/memberships/?rp=user_box_remove_ads_link";
    public static final String COMMUNITY_GUIDELINES = BASE_URL + "/community/";
    public static final String FORGOT_PASSWORD = BASE_URL + "/forgot/";
    public static final String FACEBOOK_ACCOUNT = BASE_URL + "/facebook-account/";
    public static final String PART_OF_CONTINUE_WITH_GOOGLE = "accounts.google.com";
    public static final String PART_OF_CONTINUE_WITH_APPLE = "appleid.apple.com";
}
