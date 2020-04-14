package com.example.myapplication.activities;

import android.view.View;
import android.widget.EditText;

import androidx.lifecycle.Lifecycle;
import androidx.test.core.app.ActivityScenario;
import com.example.myapplication.R;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;


@FixMethodOrder(MethodSorters.JVM)
public class MainActivityTest {

    private ActivityScenario<MainActivity> scenario;
    @Before
    public void setUp() throws Exception {


        scenario = ActivityScenario.launch(MainActivity.class);

    }

    @Test
    public void testOnCreate(){

        scenario.moveToState(Lifecycle.State.CREATED);

        scenario.onActivity((mainActivity) -> {

            View view = mainActivity.findViewById(R.id.inputValue);
            assertNotNull(view);

        });


/*        View view =  mTestMainActivity.findViewById(R.id.inputValue);
        assertNotNull(view);*/
    }


    @Test
    public void testOnResume(){
        scenario.moveToState(Lifecycle.State.RESUMED);

        scenario.onActivity((mainActivity) -> {

            View view = mainActivity.findViewById(R.id.inputValue);
            String value =((EditText)view).getEditableText().toString();
            System.out.println("Val: " + value);

            assertEquals("In Resumed State",value);

        });

    }

    @After
    public void tearDown() throws Exception {

        scenario = null;
    }
}