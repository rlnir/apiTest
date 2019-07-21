package com.apitest.auto.common;

import kong.unirest.GsonObjectMapper;
import kong.unirest.Unirest;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {

    @BeforeMethod
    public void setUp() {
        Unirest.config().reset();
        Unirest.config().setObjectMapper(new GsonObjectMapper());
        Unirest.config().connectTimeout(10000);
    }
}
