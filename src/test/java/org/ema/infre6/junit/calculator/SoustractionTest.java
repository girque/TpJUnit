package org.ema.infre6.junit.calculator;

import static org.junit.Assert.assertEquals;

import org.ema.infre6.junit.calculator.Soustraction;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SoustractionTest {

    private Soustraction soustractionClass;
    private int x1;
    private int y1;
    private int result1;
    private String signe = "-";

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        soustractionClass = new Soustraction();
        x1 = 10;
        y1 = 5;
        result1 = 5;
        signe = "-";
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testCalculer() {
        assertEquals(result1, soustractionClass.calculer(x1, y1));
    }

    @Test
    public void testErreurCalculer() {
        assertEquals(result1 + 2, soustractionClass.calculer(x1, y1));
    }

    @Test
    public void testSigne() {
        assertEquals(signe, soustractionClass.signe());
    }

}
