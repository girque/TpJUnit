package org.ema.infre6.junit.calculator;

import static org.junit.Assert.*;

import org.ema.infre6.junit.calculator.Addition;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AdditionTest {

    private Addition additionClass;
    private int x1;
    private int y1;
    private int result1;
    private String signe = "+";

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        additionClass = new Addition();
        x1 = 5;
        y1 = 5;
        result1 = 10;
        signe = "+";
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testCalculer() {
        assertEquals(result1, additionClass.calculer(x1, y1));
    }

    @Test
    public void testErreurCalculer() {
        assertEquals(result1 + 2, additionClass.calculer(x1, y1));
    }

    @Test
    public void testSigne() {
        assertEquals(signe, additionClass.signe());
    }
}