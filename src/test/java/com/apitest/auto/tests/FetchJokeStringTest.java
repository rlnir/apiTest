package com.apitest.auto.tests;

import com.apitest.auto.common.BaseTest;
import com.apitest.auto.modelobjects.JokeGson;
import com.apitest.auto.modelobjects.JokeResponse;
import com.apitest.auto.utils.JokeApiHelper;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FetchJokeStringTest extends BaseTest {

    private JokeResponse randomJoke;

    @Test
    public void fetchJokeTest() {

        // get a random joke as string
        randomJoke = JokeApiHelper.getRandomJokeString();
        System.out.println(randomJoke);

        // validate status ok
        Assert.assertEquals((int) randomJoke.getStatus(), 200, "response status should be 200");
        Assert.assertEquals(randomJoke.getStatusText(), "OK", "response status should be OK");
    }

    // validate text is present
    @Test(dependsOnMethods = "fetchJokeTest")
    public void jokeTextTest() {
        String joke = (String) randomJoke.getJoke();
        Assert.assertTrue(joke.length() > 0);
    }


}

