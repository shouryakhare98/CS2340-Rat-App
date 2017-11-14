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
 * JUnit test for getXAxisValues() in class GraphViewActivity.
 */
@RunWith(AndroidJUnit4.class)
public class SamuelShapiroJUnitTests {

    @Rule
    public ActivityTestRule<NewLoginSuccessfulActivity> nActivityRule = new ActivityTestRule<>(
            NewLoginSuccessfulActivity.class);

    /**
     * Test for getXAxisValues() in GraphViewActivity class based on invalid custom inputs.
     * @throws Exception exception.
     */
    @Test
    public void testInvalidGetXAxisValues () throws Exception {

        //type "from" and "till" years and then press the button
        onView(withId(R.id.mainMenu_fromYearGraphEditText))
                .perform(typeText("word"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.mainMenu_tillYearGraphEditText))
                .perform(typeText("again"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.mainMenu_graphViewButton)).perform(click());

        //check that the error message is displayed and activity stays the same
        onView(withId(R.id.mainMenu_incorrectDetailsTextView2)).check(matches(isDisplayed()));
    }

    /**
     * Test for getXAxisValues() in GraphViewActivity class based on valid custom inputs.
     * @throws Exception exception.
     */
    @Test
    public void testValidGetXAxisValues () throws Exception {

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

        //check that the app moves on to the next activity (inputs are valid)
        GraphViewActivity nextActivity = (GraphViewActivity) getInstrumentation().
                waitForMonitorWithTimeout(activityMonitor, 5000);
        // next activity is opened and captured.
        assertNotNull(nextActivity);
        nextActivity .finish();
    }
}