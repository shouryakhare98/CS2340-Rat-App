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
        String locationType = "";
        String address = "password";
        String zip = "John Doe";
        String city = "";
        String borough = "";
        String latitude = "";
        String Longitude = "";

        assertEquals(DatabaseHandshake.registerUser(username, password, fullName, isAdmin),
                false);

        username = "johnDoe";
        password = "";
        fullName = "John Doe";
        isAdmin = true;

        assertEquals(DatabaseHandshake.registerUser(username, password, fullName, isAdmin),
                false);

        username = "johnDoe";
        password = "password";
        fullName = "";

        assertEquals(DatabaseHandshake.registerUser(username, password, fullName, isAdmin),
                false);

        username = "johnDoe";
        password = "password";
        fullName = "John Doe";

        assertEquals(DatabaseHandshake.registerUser(username, password, fullName, isAdmin),
                true);
    }
}