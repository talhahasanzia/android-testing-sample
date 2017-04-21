package com.android.example.testsample;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;
import android.widget.Button;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by tzia on 20-Apr-17.
 */

@RunWith(AndroidJUnit4.class)
public class Main2ActivityTest
{
    @Rule
    public ActivityTestRule<Main2Activity> mActivityRule = new ActivityTestRule<>(
            Main2Activity.class );
    String prevString, postString;

    Button randomButton;

    Main2Activity main2Activity;

    public Main2ActivityTest()
    {




    }

    @Before
    public void setUp() throws Exception
    {
        main2Activity=this.mActivityRule.getActivity();

        randomButton=(Button)main2Activity.findViewById( R.id.random_button );

        prevString = "RANDOM NUMBER";
    }

    @After
    public void tearDown() throws Exception
    {

    }


    @Test
    public void generateRandomNumber() throws Exception
    {

        onView( withId( R.id.random_button ) ).perform( click() ).check( matches(withText( prevString ))  );

        Log.d( "MAIN2ACTIVITY_TEST", "prevString: "+prevString+"  postString: "+postString  );
    }

}