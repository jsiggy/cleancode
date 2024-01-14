package com.siggy.training.code.smells.calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScientificCalculatorTest {
    public static final double DEGREES_TO_RADIANS = Math.PI / 180.0;

    @Test
    void canCalculateSine() {
        assertEquals(0.0, new ScientificCalculator().sin(0.0 * DEGREES_TO_RADIANS), 0.001);
        assertEquals(0.5, new ScientificCalculator().sin(30.0 * DEGREES_TO_RADIANS), 0.001);
        assertEquals(0.7071, new ScientificCalculator().sin(45.0 * DEGREES_TO_RADIANS), 0.001);
        assertEquals(0.866, new ScientificCalculator().sin(60.0 * DEGREES_TO_RADIANS), 0.001);
        assertEquals(1.0, new ScientificCalculator().sin(90.0 * DEGREES_TO_RADIANS), 0.001);
        assertEquals(0.0, new ScientificCalculator().sin(180.0 * DEGREES_TO_RADIANS), 0.001);
    }

    @Test
    void canCalculateCosine() {
        assertEquals(1.0, new ScientificCalculator().cos(0.0 * DEGREES_TO_RADIANS), 0.001);
        assertEquals(0.866, new ScientificCalculator().cos(30.0 * DEGREES_TO_RADIANS), 0.001);
        assertEquals(0.7071, new ScientificCalculator().cos(45.0 * DEGREES_TO_RADIANS), 0.001);
        assertEquals(0.5, new ScientificCalculator().cos(60.0 * DEGREES_TO_RADIANS), 0.001);
        assertEquals(0.0, new ScientificCalculator().cos(90.0 * DEGREES_TO_RADIANS), 0.001);
        assertEquals(-1.0, new ScientificCalculator().cos(180.0 * DEGREES_TO_RADIANS), 0.001);
    }
}
