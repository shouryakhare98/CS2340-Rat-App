package com.example.shouryakhare.cs2340_rat_app;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.core.deps.dagger.internal.Beta;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ActivityUnitTestCase;

import com.example.shouryakhare.cs2340_rat_app.Controller.GraphViewActivity;
import com.example.shouryakhare.cs2340_rat_app.Controller.ReportSightingActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;

import static android.support.test.espresso.Espresso.closeSoftKeyboard;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static java.util.regex.Pattern.matches;
import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * JUnit test for getXAxisValues() in class GraphViewActivity.
 */
@RunWith(AndroidJUnit4.class)
public class SamuelShapiroJUnitTests {

    @Rule
    public ActivityTestRule<GraphViewActivity> gActivityRule = new ActivityTestRule<>(
            GraphViewActivity.class);

    /**
     * Test for getXAxisValues() in GraphViewActivity class.
     * @throws Exception exception.
     */
    @Test
    public void testGetXAxisValues() throws Exception {
        //login with a valid account
        onView(withId(R.id.mainActivity_usernameTextField))
                .perform(typeText("sam"));
        onView(withId(R.id.mainActivity_passwordTextField))
                .perform(typeText("1234"));
        onView(withId(R.id.mainActivity_loginButton)).perform(click());

        //type "from" and "till" years and then press the button
        onView(withId(R.id.mainMenu_fromYearGraphEditText))
                .perform(typeText("2015"));
        onView(withId(R.id.mainMenu_tillYearGraphEditText))
                .perform(typeText("2017"));
        onView(withId(R.id.mainMenu_graphViewButton)).perform(click());

        //check that the x-axis values are what we expected
        String[] xValues = gActivityRule.getActivity().returnXAxisValues();
        assertEquals(xValues[0], "1/2015");
        assertEquals(xValues[xValues.length - 1], "12/2017");
    }
}