package com.example.shouryakhare.cs2340_rat_app;

import static org.junit.Assert.assertEquals;

import android.support.test.rule.ActivityTestRule;

import com.example.shouryakhare.cs2340_rat_app.Controller.GraphViewActivity;

import org.junit.Rule;
import org.junit.Test;

/**
 * Created by samshapiro on 11/14/17.
 */

public class SamuelShapiroJUnitTests2 {

    @Rule
    public static ActivityTestRule<GraphViewActivity> gActivityRule = new ActivityTestRule<>(
            GraphViewActivity.class);

    /**
     * Test for getXAxisValues() in GraphViewActivity class using default axis values.
     *
     * @throws Exception exception.
     */
    @Test
    public void testDefaultGetXAxisValues() throws Exception {

        //check that the x-axis values are what is set as the default in our code
        String[] xValues = gActivityRule.getActivity().returnXAxisValues();
        assertEquals(xValues[0], "1/2015");
        assertEquals(xValues[xValues.length - 1], "12/2017");
    }
}
