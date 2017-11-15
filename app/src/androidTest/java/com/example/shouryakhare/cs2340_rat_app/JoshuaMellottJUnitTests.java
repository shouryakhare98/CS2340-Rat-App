package com.example.shouryakhare.cs2340_rat_app;

import android.app.Instrumentation;
import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.example.shouryakhare.cs2340_rat_app.Controller.GraphViewActivity;
import com.example.shouryakhare.cs2340_rat_app.Controller.NewLoginSuccessfulActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.InstrumentationRegistry.getTargetContext;
import static android.support.test.espresso.Espresso.closeSoftKeyboard;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

import static junit.framework.Assert.assertNotNull;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * JUnit test for getYAxisValues() in class GraphViewActivity.
 */

@RunWith(AndroidJUnit4.class)
public class JoshuaMellottJUnitTests {
    @Rule
    public ActivityTestRule<NewLoginSuccessfulActivity> nActivityRule = new ActivityTestRule<>(
            NewLoginSuccessfulActivity.class);

    /**
     * Test for getYAxisValues() in GraphViewActivity class with invalid inputs.
     * @throws Exception exception.
     */
    @Test
    public void testInvalidGetYAxisValues() throws Exception {
        //type "from" and "till" years and then press the button
        onView(withId(R.id.mainMenu_fromYearGraphEditText))
                .perform(typeText("invalid"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.mainMenu_tillYearGraphEditText))
                .perform(typeText("invalid"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.mainMenu_graphViewButton)).perform(click());

        //check that the error message is displayed and activity stays the same
        onView(withId(R.id.mainMenu_incorrectDetailsTextView2)).check(matches(isDisplayed()));
    }

    /**
     * Test for getYAxisValues() in GraphViewActivity class with valid inputs.
     * @throws Exception exception.
     */
    @Test
    public void testValidGetYAxisValues() throws Exception {
        Instrumentation.ActivityMonitor activityMonitor = getInstrumentation()
                .addMonitor(GraphViewActivity.class.getName(), null, false);

        //type "from" and "till" years and then press the button
        onView(withId(R.id.mainMenu_fromYearGraphEditText))
                .perform(typeText("2014"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.mainMenu_tillYearGraphEditText))
                .perform(typeText("2016"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.mainMenu_graphViewButton)).perform(click());

        //check that inputs are valid, thus starting new activity
        GraphViewActivity nextActivity = (GraphViewActivity) getInstrumentation().
                waitForMonitorWithTimeout(activityMonitor, 5000);

        //next activity is opened and checked
        assertNotNull(nextActivity);
        nextActivity.finish();
    }
}