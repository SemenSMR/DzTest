package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void before() {
        calculator = new Calculator();
    }

    @Test
    void testPlus() {
        int sum = calculator.plus.apply(5, 15);
        Assertions.assertEquals(20, sum);

    }

    @Test
    void testMinus() {
        int sum = calculator.minus.apply(15, 2);
        Assertions.assertEquals(13, sum);

    }

    @Test
    void testMultiply() {
        int sum = calculator.multiply.apply(2, 3);
        Assertions.assertEquals(6, sum);

    }

    @Test
    void testDivide() {
        int sum = calculator.divide.apply(3, 0);
        Assertions.assertEquals(0, sum);

    }
    @Test
    void testPow() {
        int sum = calculator.pow.apply(5);
        Assertions.assertEquals(25, sum);

    }
    @Test
    void testAbs() {
        int sum = calculator.abs.apply(6);
        Assertions.assertFalse(sum == 7);

    }
    @Test
    void testIsPositive() {
        boolean sum = calculator.isPositive.test(-5);
        Assertions.assertFalse(sum);

    }
}