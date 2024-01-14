package com.siggy.training.code.smells.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScientificCalculatorTest {
    public static final double DEGREES_TO_RADIANS = Math.PI / 180.0;
    private ScientificCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new ScientificCalculator();
    }

    @Test
    void canCalculateSine() {
        assertEquals(0.0, calculator.sin(0.0 * DEGREES_TO_RADIANS), 0.001);
        assertEquals(0.5, calculator.sin(30.0 * DEGREES_TO_RADIANS), 0.001);
        assertEquals(0.7071, calculator.sin(45.0 * DEGREES_TO_RADIANS), 0.001);
        assertEquals(0.866, calculator.sin(60.0 * DEGREES_TO_RADIANS), 0.001);
        assertEquals(1.0, calculator.sin(90.0 * DEGREES_TO_RADIANS), 0.001);
        assertEquals(0.0, calculator.sin(180.0 * DEGREES_TO_RADIANS), 0.001);
    }

    @Test
    void canCalculateCosine() {
        assertEquals(1.0, calculator.cos(0.0 * DEGREES_TO_RADIANS), 0.001);
        assertEquals(0.866, calculator.cos(30.0 * DEGREES_TO_RADIANS), 0.001);
        assertEquals(0.7071, calculator.cos(45.0 * DEGREES_TO_RADIANS), 0.001);
        assertEquals(0.5, calculator.cos(60.0 * DEGREES_TO_RADIANS), 0.001);
        assertEquals(0.0, calculator.cos(90.0 * DEGREES_TO_RADIANS), 0.001);
        assertEquals(-1.0, calculator.cos(180.0 * DEGREES_TO_RADIANS), 0.001);
    }
}
