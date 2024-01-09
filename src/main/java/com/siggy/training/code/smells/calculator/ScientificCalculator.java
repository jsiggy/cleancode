package com.siggy.training.code.smells.calculator;

public class ScientificCalculator extends ArithmeticCalculator {

    @Override
    public double sin(double value) {
        return Math.sin(value);
    }

    @Override
    public double cos(double value) {
        return Math.cos(value);
    }
}
