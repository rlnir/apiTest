package com.apitest.auto.utils;

import com.apitest.auto.modelobjects.JokeGson;
import com.apitest.auto.modelobjects.JokeResponse;
import kong.unirest.Headers;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

import java.util.HashMap;
import java.util.Map;

/**
 * wrapper for dad joke api
 */

public class JokeApiHelper {

    public static JokeResponse getRandomJoke() {
        return getJokeAs(JokeGson.class, "");
    }

    public static JokeResponse getJoke(String id) {
        return getJokeAs(JokeGson.class, "/j/" + id);
    }

    public static JokeResponse getJokeString(String id) {
        return getJokeAsString("/j/" + id);
    }

    public static JokeResponse getRandomJokeString() {
        return getJokeAsString("");
    }

    // get Joke response with Object of Generic type (JokeGson, (JokeJackson-not implemented))
    private static <T> JokeResponse getJokeAs(Class<T> cls, String id) {
        try {
            HttpResponse<T> httpResponse = Unirest.get(ProjectTestProps.getBaseUrl() + id)
                    .headers(getHeadersFor("JSON"))
                    .asObject(cls);
            Headers headers = httpResponse.getHeaders();
            int status = httpResponse.getStatus();
            String statusText = httpResponse.getStatusText();
            T joke = httpResponse.getBody();
            return new JokeResponse(joke, status, statusText, headers);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // get joke response with String
    private static JokeResponse getJokeAsString(String id) {
        try {
            HttpResponse<String> httpResponse = Unirest.get(ProjectTestProps.getBaseUrl() + id)
                    .headers(getHeadersFor("String"))
                    .asString();
            Headers headers = httpResponse.getHeaders();
            int status = httpResponse.getStatus();
            String statusText = httpResponse.getStatusText();
            String joke = httpResponse.getBody();
            return new JokeResponse(joke, status, statusText, headers);
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
