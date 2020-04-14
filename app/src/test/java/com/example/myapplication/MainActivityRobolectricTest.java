package com.example.myapplication;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.example.myapplication.activities.MainActivity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(RobolectricTestRunner.class)
public class MainActivityRobolectricTest {

    @Test
    public void testOnCreate(){
        MainActivity mainActivity = Robolectric.buildActivity(MainActivity.class).create().get();

        View view = mainActivity.findViewById(R.id.inputValue);
        assertNotNull(view);

        String value =((EditText)view).getEditableText().toString();
        System.out.println("Val: " + value);
        assertTrue(TextUtils.isEmpty(value));
    }

    @Test
    public void testOnResume(){

        MainActivity mainActivity = Robolectric.buildActivity(MainActivity.class).create().resume().get();

        View view = mainActivity.findViewById(R.id.inputValue);

        String value =((EditText)view).getEditableText().toString();
        System.out.println("Val: " + value);

        assertNotNull(value);
        assertEquals("In Resumed State", value);
        //assertTrue("In Resumed State".equals(value));
    }
}
