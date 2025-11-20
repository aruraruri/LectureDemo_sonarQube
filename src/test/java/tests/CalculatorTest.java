package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    @Test
    void addValues() {
        Assertions.assertEquals(4, calc.Calculator.addValues(2, 2));
    }

    @Test
    void divideValues() {
        Assertions.assertEquals(2, calc.Calculator.divideValues(4, 2));
    }

    @Test
    void multiplyValues() {
        Assertions.assertEquals(4, calc.Calculator.multiplyValues(2, 2));
    }
}