package com.apitest.auto.tests;

import com.apitest.auto.common.BaseTest;
import com.apitest.auto.modelobjects.JokeGson;
import com.apitest.auto.modelobjects.JokeResponse;
import com.apitest.auto.utils.JokeApiHelper;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FetchJokeIdTest extends BaseTest {

    private JokeResponse jokeId;
    private JokeResponse randomJoke;
    private JokeResponse jokeIdString;

    @Test
    public void fetchJokeTest() {

        // get a random joke
        randomJoke = JokeApiHelper.getRandomJoke();
        System.out.println(randomJoke);
        JokeGson joke = (JokeGson) randomJoke.getJoke();

        // get id from the random joke
        String id = joke.getId();

        // fetch the same joke with id
        jokeId = JokeApiHelper.getJoke(id);

        // fetch the same joke with id as string
        jokeIdString = JokeApiHelper.getJokeString(id);

        // validate status ok
        Assert.assertEquals((int) jokeId.getStatus(), 200, "response status should be 200");
        Assert.assertEquals(jokeId.getStatusText(), "OK", "response status should be OK");

        Assert.assertEquals((int) jokeIdString.getStatus(), 200, "response status should be 200");
        Assert.assertEquals(jokeIdString.getStatusText(), "OK", "response status should be OK");
    }

    // validate text is present
    @Test(dependsOnMethods = "fetchJokeTest")
    public void jokeTextTest() {
        JokeGson joke = (JokeGson) jokeId.getJoke();
        Assert.assertTrue(joke.getJoke().length() > 0);
    }

    // validate text is present (string api joke)
    @Test(dependsOnMethods = "fetchJokeTest")
    public void jokeStringTextTest() {
        Assert.assertTrue(((String)jokeIdString.getJoke()).length() > 0);
    }

    // validate joke id
    @Test(dependsOnMethods = "fetchJokeTest")
    public void jokeIdTest() {
        JokeGson joke = (JokeGson) jokeId.getJoke();
        Assert.assertTrue(joke.getId().length() > 9);

    }

    // validate that joke that was fetched randomly identical to joke fetched with id
    @Test(dependsOnMethods = "fetchJokeTest")
    public void compareJokes() {
        JokeGson joke = (JokeGson) jokeId.getJoke();
        JokeGson randomJoke = (JokeGson) this.randomJoke.getJoke();

        Assert.assertEquals(randomJoke, joke, "joke that was fetched randomly isn't identical to joke fetched with id (json body joke)");

    }

    // validate that joke that was fetched randomly identical to joke fetched with id (string api)
    @Test(dependsOnMethods = "fetchJokeTest")
    public void compareStringJokes() {
        JokeGson randomJoke = (JokeGson) this.randomJoke.getJoke();

        Assert.assertEquals(randomJoke.getJoke(), (String) jokeIdString.getJoke(), "joke that was fetched randomly isn't identical to joke fetched with id (string body joke)");

    }


}

