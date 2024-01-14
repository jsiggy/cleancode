package com.siggy.training.code.smells.calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArithmeticCalculatorTest {
    @Test
    void canAdd() {
        assertEquals(35, new ArithmeticCalculator().add(20, 15));
    }

    @Test
    void canSubtract() {
        assertEquals(-12, new ArithmeticCalculator().subtract(75, 87));
    }

    @Test
    void canMultiply() {
        assertEquals(3577, new ArithmeticCalculator().multiply(49, 73));
    }

    @Test
    void canDivide() {
        assertEquals(5, new ArithmeticCalculator().divide(80, 16));
    }

    @Test
    void shouldFailSine() {
        assertThrows(UnsupportedOperationException.class,
                ()->new ArithmeticCalculator().sin(0.0));
    }

    @Test
    void shouldFailCosine() {
        assertThrows(UnsupportedOperationException.class,
                ()->new ArithmeticCalculator().cos(0.0));
    }
}
