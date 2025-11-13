package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    @Test
    void addValues() {
        Assertions.assertEquals(4, main.Calculator.addValues(2, 2));
    }

    @Test
    void divideValues() {
        Assertions.assertEquals(2, main.Calculator.divideValues(4, 2));
    }

    @Test
    void multiplyValues() {
        Assertions.assertEquals(4, main.Calculator.multiplyValues(2, 2));
    }
}