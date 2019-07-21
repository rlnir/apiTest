package com.apitest.auto.utils;


import com.apitest.auto.common.TestProps;

public class ProjectTestProps {

    public static String getBaseUrl() {
        return TestProps.get("baseUrl");
    }
}
