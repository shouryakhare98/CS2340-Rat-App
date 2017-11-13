package com.example.shouryakhare.cs2340_rat_app;

import com.example.shouryakhare.cs2340_rat_app.Controller.GraphViewActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * JUnit test for getYAxisValues() in class GraphViewActivity.
 */

@RunWith(AndroidJUnit4.class)
public class JoshuaMellottJUnitTests {

    @Rule
    public ActivityTestRule<GraphViewActivity> gActivityRule = new ActivityTestRule<>(
            GraphViewActivity.class);

    /**
     * Test for getYAxisValues() in GraphViewActivity class.
     * @throws Exception exception.
     */
    @Test
    public void testGetYAxisValues() throws Exception {
        //login with a valid account
        onView(withId(R.id.mainActivity_usernameTextField))
                .perform(typeText("josh"));
        onView(withId(R.id.mainActivity_passwordTextField))
                .perform(typeText("1234"));
        onView(withId(R.id.mainActivity_loginButton)).perform(click());

        //type "from" and "till" years and then press the button
        onView(withId(R.id.mainMenu_fromYearGraphEditText))
                .perform(typeText("2015"));
        onView(withId(R.id.mainMenu_tillYearGraphEditText))
                .perform(typeText("2017"));
        onView(withId(R.id.mainMenu_graphViewButton)).perform(click());

        //check that the y-axis values are what we expected
        String[] yValues = gActivityRule.getActivity().returnYAxisValues();
        assertEquals(yValues[0], "0");
        assertEquals(yValues[yValues.length - 1], "80");
    }
}