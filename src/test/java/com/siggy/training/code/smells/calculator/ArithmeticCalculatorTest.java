package com.siggy.training.code.smells.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArithmeticCalculatorTest {

    private ArithmeticCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new ArithmeticCalculator();
    }

    @Test
    void canAdd() {
        assertEquals(35, calculator.add(20, 15));
    }

    @Test
    void canSubtract() {
        assertEquals(-12, calculator.subtract(75, 87));
    }

    @Test
    void canMultiply() {
        assertEquals(3577, calculator.multiply(49, 73));
    }

    @Test
    void canDivide() {
        assertEquals(5, calculator.divide(80, 16));
    }

    @Test
    void shouldFailSine() {
        assertThrows(UnsupportedOperationException.class,
                ()-> calculator.sin(0.0));
    }

    @Test
    void shouldFailCosine() {
        assertThrows(UnsupportedOperationException.class,
                ()-> calculator.cos(0.0));
    }
}
