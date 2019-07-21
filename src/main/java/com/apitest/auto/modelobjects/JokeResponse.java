package com.apitest.auto.modelobjects;


import kong.unirest.Headers;

/**
 * this class represents the joke response structure
 * T is a generic type (JokeGson, String)
 *
 * @param <T>
 */
public class JokeResponse<T> {

    private T joke;
    private int status;
    private String statusText;
    private Headers headers;

    public JokeResponse(T joke, int status, String statusText, Headers headers) {
        this.joke = joke;
        this.status = status;
        this.statusText = statusText;
        this.headers = headers;
    }

    public T getJoke() {
        return joke;
    }

    public int getStatus() {
        return status;
    }

    public String getStatusText() {
        return statusText;
    }

    public Headers getHeaders() {
        return headers;
    }

    @Override
    public String toString() {
        return "JokeResponse{" +
                "joke=" + joke +
                ", status=" + status +
                ", statusText='" + statusText + '\'' +
                ", headers=" + headers +
                '}';
    }
}


