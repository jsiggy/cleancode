package com.siggy.training.code.smells.calculator;

public class ArithmeticCalculator implements Calculator {
    @Override
    public long add(long operand1, long operand2) {
        return operand1 + operand2;
    }

    @Override
    public long subtract(long operand1, long operand2) {
        return operand1 - operand2;
    }

    @Override
    public long multiply(long operand1, long operand2) {
        return operand1 * operand2;
    }

    @Override
    public long divide(long operand1, long operand2) {
        return operand1 / operand2;
    }

    @Override
    public double sin(double value) {
        throw new UnsupportedOperationException("Trigonometric functions not supported");
    }

    @Override
    public double cos(double value) {
        throw new UnsupportedOperationException("Trigonometric functions not supported");
    }
}
