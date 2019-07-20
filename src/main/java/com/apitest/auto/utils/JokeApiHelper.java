package com.apitest.auto.utils;

import com.apitest.auto.modelobjects.Joke;
import kong.unirest.Unirest;

import java.util.HashMap;
import java.util.Map;

public class JokeApiHelper {

    public static Joke getRandomJoke() {
        return getJokeAs(Joke.class, "");
    }

    public static Joke getJoke(String id) {
        return getJokeAs(Joke.class, "/j/" + id);
    }

    public static String getJokeString(String id) {
        return getJokeAsString("/j/" + id);
    }

    public static String getRandomJokeString() {
        return getJokeAsString("");
    }

    public static <T> T getJokeAs(Class<T> cls, String id) {
        try {
            T joke = Unirest.get(ProjectTestProps.getBaseUrl() + id)
                    .headers(getHeadersFor("JSON"))
                    .asObject(cls)
                    .getBody();
            return joke;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getJokeAsString(String id) {
        try {
            return Unirest.get(ProjectTestProps.getBaseUrl() + id)
                    .headers(getHeadersFor("String"))
                    .asString()
                    .getBody();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Map<String, String> getHeadersFor(String type) {
        Map<String, String> headers = new HashMap<String, String>();
        switch (type.toLowerCase()) {
            case "json":
                headers.put("accept", "application/json");
                return headers;
            case "string":
            default:
                headers.put("Accept", "text/plain");
                return headers;
        }
    }
}
