package com.apitest.auto.tests;

import com.apitest.auto.common.BaseTest;
import com.apitest.auto.modelobjects.JokeGson;
import com.apitest.auto.modelobjects.JokeResponse;
import com.apitest.auto.utils.JokeApiHelper;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *  test random joke api for json response
 *
 *  GET https://icanhazdadjoke.com/
 *
 */

public class FetchJokeTest extends BaseTest {

    private JokeResponse randomJoke;

    @Test
    public void fetchJokeTest() {

        // get a random joke
        randomJoke = JokeApiHelper.getRandomJoke();
        System.out.println(randomJoke);


        // validate status ok
        Assert.assertEquals((int) randomJoke.getStatus(), 200, "response status should be 200");
        Assert.assertEquals(randomJoke.getStatusText(), "OK", "response status should be OK");
    }

    // validate text is present
    @Test(dependsOnMethods = "fetchJokeTest")
    public void jokeTextTest() {
        JokeGson joke = (JokeGson) randomJoke.getJoke();
        Assert.assertTrue(joke.getJoke().length() > 0, "no text in joke response");
    }

    // validate joke id
    @Test(dependsOnMethods = "fetchJokeTest")
    public void jokeIdTest() {
        JokeGson joke = (JokeGson) randomJoke.getJoke();
        Assert.assertTrue(joke.getId().length() > 9, "joke id length is invalid");
    }

}

