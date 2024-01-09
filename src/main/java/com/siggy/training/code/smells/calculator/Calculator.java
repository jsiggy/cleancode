package com.siggy.training.code.smells.calculator;

public interface Calculator {
    long add(long operand1, long operand2);
    long subtract(long operand1, long operand2);
    long multiply(long operand1, long operand2);
    long divide(long operand1, long operand2);
    double sin(double value);
    double cos(double value);
}
