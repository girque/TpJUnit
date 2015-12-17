package org.ema.infre6.junit.calculator;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AdditionTest.class, SoustractionTest.class,
        MultiplicationTest.class, DivisionTest.class })
public class CampagneTest {

}
