package com.apitest.auto.common;

import io.qameta.allure.Step;
import kong.unirest.GsonObjectMapper;
import kong.unirest.Unirest;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {

    @Step
    @BeforeMethod
    public void setUp() {
        Unirest.config().reset();
        Unirest.config().setObjectMapper(new GsonObjectMapper());
        Unirest.config().connectTimeout(10000);
    }
}
