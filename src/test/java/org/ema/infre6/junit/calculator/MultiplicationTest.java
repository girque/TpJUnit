package org.ema.infre6.junit.calculator;

import static org.junit.Assert.*;

import org.ema.infre6.junit.calculator.Multiplication;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MultiplicationTest {

    private Multiplication multiplicationClass;
    private int x1;
    private int y1;
    private int result1;
    private String signe = "*";

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        multiplicationClass = new Multiplication();
        x1 = 5;
        y1 = 5;
        result1 = 25;
        signe = "*";
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testCalculer() {
        assertEquals(result1, multiplicationClass.calculer(x1, y1));
    }

    @Test
    public void testErreurCalculer() {
        assertEquals(result1 + 2, multiplicationClass.calculer(x1, y1));
    }

    @Test
    public void testSigne() {
        assertEquals(signe, multiplicationClass.signe());
    }

}
