package com.example.myapplication;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect()
    {
        assertEquals("addition failed",4, 2 + 2, 0.001);
    }
    @Test
    public void subtraction_isCorrect()
    {
        assertEquals("subtraction failed",9, 11 - 2, 0.001);
    }
}