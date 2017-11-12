package com.example.shouryakhare.cs2340_rat_app;

import android.support.test.runner.AndroidJUnit4;

import com.example.shouryakhare.cs2340_rat_app.Controller.NewLoginSuccessfulActivity;
import com.example.shouryakhare.cs2340_rat_app.Controller.ReportSightingActivity;
import com.example.shouryakhare.cs2340_rat_app.Model.DatabaseHandshake;

import org.junit.Test;
import org.junit.runner.RunWith;
import android.content.Intent;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * JUnit test for onSubmitPressed() in class ReportSightingActivity.
 */
@RunWith(AndroidJUnit4.class)
public class LaneHomrichJUnitTests {

    /**
     * Test for onSubmitPressed() in ReportSightingActivity class.
     * @throws Exception exception.
     */
    @Test
    public void testOnSubmitPressed() throws Exception {
        String locationType = "Home";
        String address = "123 Main Street";
        String zip = "30318";
        String city = "New York";
        String borough = "Brooklyn";
        String latitude = "123";
        String longitude = "123";
        Intent checkIntent = new Intent();

        assertEquals(DatabaseHandshake.addSighting(locationType, address, zip, city, borough,
                latitude, longitude), true);
        assertEquals(checkIntent.getClass(), NewLoginSuccessfulActivity.class);

        locationType = "Home";
        address = "";
        zip = "30318";
        city = "New York";
        borough = "Brooklyn";
        latitude = "";
        longitude = "123";

        assertEquals(DatabaseHandshake.addSighting(locationType, address, zip, city, borough,
                latitude, longitude), false);
        assertNotEquals(checkIntent.getClass(), NewLoginSuccessfulActivity.class);

        locationType = "";
        address = "";
        zip = "";
        city = "";
        borough = "";
        latitude = "";
        longitude = "";

        assertEquals(DatabaseHandshake.addSighting(locationType, address, zip, city, borough,
                latitude, longitude), false);
        assertNotEquals(checkIntent.getClass(), NewLoginSuccessfulActivity.class);
    }
}
