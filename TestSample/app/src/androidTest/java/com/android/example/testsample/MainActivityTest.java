package com.android.example.testsample;

import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.filters.LargeTest;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.ComponentNameMatchers.hasShortClassName;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.intent.matcher.IntentMatchers.toPackage;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;


/**
 * Created by tzia on 20-Apr-17.
 */

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest
{
    @Rule
    public IntentsTestRule<MainActivity> mIntentsRule =
        new IntentsTestRule<>(MainActivity.class);


    @Before
    public void setUp() throws Exception
    {

    }

    @After
    public void tearDown() throws Exception
    {

    }

    @Test
    public void onClick() throws Exception
    {
        /*
         * This will fail since edit text will not have right text
         */

        // Clicks a button to send the message to another
        // activity through an explicit intent.
        onView(withId(R.id.next_activity_button)).perform(click());

        // Verifies that the Main2Activity received an intent
        // with the correct package name and message.
        intended(allOf(
                hasComponent(hasShortClassName(".Main2Activity")),
                toPackage("com.android.example.testsample")));




    }

    @Test
    public void onClickWithWrongInputText() throws Exception
    {
        /*
         * This will fail since edit text will not have right text
         */

        onView(withId(R.id.editText)).perform(click(), typeText("Engineer"));
        // Clicks a button to send the message to another
        // activity through an explicit intent.
        onView(withId(R.id.next_activity_button)).perform(click());

        // Verifies that the Main2Activity received an intent
        // with the correct package name and message.
        intended(allOf(
                hasComponent(hasShortClassName(".Main2Activity")),
                toPackage("com.android.example.testsample")));




    }


    @Test
    public void onClickWithRightInputText() throws Exception
    {
        /*
         * This should pass since edit text will have right text
         */


        onView(withId(R.id.editText)).perform(click(), replaceText("")); // clear edittext
        onView(withId(R.id.editText)).perform(click(), typeText("magic word")); // enter right word
        // Clicks a button to send the message to another
        // activity through an explicit intent.
        onView(withId(R.id.next_activity_button)).perform(click());

        // Verifies that the Main2Activity received an intent
        // with the correct package name and message.
        intended(allOf(
                hasComponent(hasShortClassName(".Main2Activity")),
                toPackage("com.android.example.testsample")));




    }


}