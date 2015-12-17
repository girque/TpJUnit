package org.ema.infre6.junit.calculator;

import static org.junit.Assert.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.ema.infre6.junit.calculator.Division;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DivisionTest {

    private static Logger logManager = LogManager.getLogger(DivisionTest.class
            .getName());

    private Division divisionClass;
    private int x1;
    private int y1;
    private int result1;
    private String signe = "/";

    private int x2;
    private int y2;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {

        /* tests valeurs valides */
        divisionClass = new Division();
        x1 = 10;
        y1 = 5;
        result1 = 2;
        signe = "/";

        /* tests valeurs invalides */
        x2 = 5;
        y2 = 0;

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testCalculer() {
        try {
            assertEquals(result1, divisionClass.calculer(x1, y1));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testErreurCalculer() {
        try {
            assertEquals(result1 + 2, divisionClass.calculer(x1, y1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDivisionParZero() {
        try {
            assertEquals(java.lang.ArithmeticException.class,
                    divisionClass.calculer(x2, y2));
        } catch (Exception e) {
            logManager.fatal("Division par zéro");
        }
    }

    @Test(expected = NumberFormatException.class)
    public void testDivisionParZeroAnnotation() {
        assertEquals(java.lang.ArithmeticException.class,
                divisionClass.calculer(x2, y2));
    }

    @Test
    public void testSigne() {
        assertEquals(signe, divisionClass.signe());
    }
}