package com.apitest.auto.modelobjects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

/**
 * this class represents a joke of Gson builder
 */
public class JokeGson {


    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("joke")
    @Expose
    private String joke;
    @SerializedName("status")
    @Expose
    private Integer status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJoke() {
        return joke;
    }

    public void setJoke(String joke) {
        this.joke = joke;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Example{" +
                "id='" + id + '\'' +
                ", joke='" + joke + '\'' +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JokeGson jokeGson = (JokeGson) o;
        return Objects.equals(id, jokeGson.id) &&
                Objects.equals(joke, jokeGson.joke) &&
                Objects.equals(status, jokeGson.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, joke, status);
    }
}
