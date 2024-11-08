package com.example.calc;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;



public class MainActivityTest {

    @Test
    public void testClickResult_Addition() {

        assertEquals("8", MainActivity.SetNumber(R.id.button8, "0", true));
        assertNotEquals("6", MainActivity.SetNumber(R.id.button8, "0", true));
        assertEquals("27", MainActivity.SetNumber(R.id.button7, "2", false));
    }
    @Test
    public void testClickResult_Subtraction() {
        assertEquals("-", MainActivity.SetOperator(R.id.buttonMinus));
        assertNotEquals("+", MainActivity.SetOperator(R.id.buttonMinus));
    }

}
