package org.ema.infre6.junit.calculator;

public class Division {

    public int calculer(int x, int y) throws NumberFormatException {
        int result = 0;

        if (y == 0) {
            throw new NumberFormatException("Division par zéro");
        }

        result = x / y;
        return result;
    }

    public String signe() {
        return "/";
    }
}
