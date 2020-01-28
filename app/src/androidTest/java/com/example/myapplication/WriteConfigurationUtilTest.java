package com.example.myapplication;


import android.content.Context;

import com.example.myapplication.utils.WriteConfigurationUtil;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.io.FileOutputStream;

import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.times;

public class WriteConfigurationUtilTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    public Context context;

    @Mock
    public FileOutputStream fileOutputStream;

    @Test
    public void writeShouldWriteTwiceToFileSystem(){

        try{

            when(context.openFileOutput(anyString(), anyInt())).thenReturn(fileOutputStream);

            WriteConfigurationUtil.writeConfiguration(context);
            verify(context, times(1)).openFileOutput(anyString(), anyInt());
            verify(fileOutputStream, atLeast(2)).write(any(byte[].class));

        }catch (Exception e){
            e.printStackTrace();
            fail();
        }
    }
}
