package com.example.shouryakhare.cs2340_rat_app;

import android.support.test.runner.AndroidJUnit4;

import com.example.shouryakhare.cs2340_rat_app.Model.DatabaseHandshake;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * JUnit test for registerUser() in class DatabaseHandshake.
 */
@RunWith(AndroidJUnit4.class)
public class ShouryaKhareJUnitTests {

    /**
     * Test for registerUser() in DatabaseHandshake class.
     * @throws Exception exception.
     */
    @Test
    public void testRegisterUser() throws Exception {
        String username = "";
        String password = "password";
        String fullName = "John Doe";
        boolean isAdmin = false;

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
