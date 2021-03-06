package com.example.shouryakhare.cs2340_rat_app;

import android.support.test.runner.AndroidJUnit4;

import com.example.shouryakhare.cs2340_rat_app.Model.DatabaseHandshake;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * JUnit test for addSighting() in class DatabaseHandshake.
 */
@RunWith(AndroidJUnit4.class)
public class ReaganMatthewsJUnitTests {

    /**
     * Test for addSighting() in DatabaseHandshake class.
     * @throws Exception exception.
     */
    @Test
    public void testaddSighting() throws Exception {

//check that each field will not be accepted if empty
        String locationType = "Commercial";
        String address = "75 5th Street NW";
        String zip = "30309";
        String city = "Atlanta";
        String borough = "Midtown";
        String latitude = "18.18";
        String longitude = "";

        assertEquals(DatabaseHandshake.addSighting(locationType, address, zip, city, borough, latitude, longitude),
                false);

        locationType = "Commercial";
        address = "75 5th Street NW";
        zip = "30309";
        city = "Atlanta";
        borough = "Midtown";
        latitude = "";
        longitude = "12.12";

        assertEquals(DatabaseHandshake.addSighting(locationType, address, zip, city, borough, latitude, longitude),
                false);

        locationType = "Commercial";
        address = "75 5th Street NW";
        zip = "30309";
        city = "Atlanta";
        borough = "";
        latitude = "18.18";
        longitude = "12.12";

        assertEquals(DatabaseHandshake.addSighting(locationType, address, zip, city, borough, latitude, longitude),
                false);

        locationType = "Commercial";
        address = "75 5th Street NW";
        zip = "30309";
        city = "";
        borough = "Midtown";
        latitude = "18.18";
        longitude = "12.12";

        assertEquals(DatabaseHandshake.addSighting(locationType, address, zip, city, borough, latitude, longitude),
                false);

        locationType = "Commercial";
        address = "75 5th Street NW";
        zip = "";
        city = "Atlanta";
        borough = "Midtown";
        latitude = "18.18";
        longitude = "12.12";

        assertEquals(DatabaseHandshake.addSighting(locationType, address, zip, city, borough, latitude, longitude),
                false);

        locationType = "Commercial";
        address = "";
        zip = "30309";
        city = "Atlanta";
        borough = "Midtown";
        latitude = "18.18";
        longitude = "12.12";

        assertEquals(DatabaseHandshake.addSighting(locationType, address, zip, city, borough, latitude, longitude),
                false);

        locationType = "";
        address = "75 5th Street NW";
        zip = "30309";
        city = "Atlanta";
        borough = "Midtown";
        latitude = "18.18";
        longitude = "12.12";

        assertEquals(DatabaseHandshake.addSighting(locationType, address, zip, city, borough, latitude, longitude),
                false);


//check that latitudes and longitudes are not accepted if not doubles
        locationType = "Commercial";
        address = "75 5th Street NW";
        zip = "30309";
        city = "Atlanta";
        borough = "Midtown";
        latitude = "ABC";
        longitude = "12.12";

        assertEquals(DatabaseHandshake.addSighting(locationType, address, zip, city, borough, latitude, longitude),
                false);

        locationType = "Commercial";
        address = "75 5th Street NW";
        zip = "30309";
        city = "Atlanta";
        borough = "Midtown";
        latitude = "18.18";
        longitude = "ABC";

        assertEquals(DatabaseHandshake.addSighting(locationType, address, zip, city, borough, latitude, longitude),
                false);

    }
}