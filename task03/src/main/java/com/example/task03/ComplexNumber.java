package com.example.task03;

public class ComplexNumber {
    private final double real;
    private final double imaginary;

    public double getRealValue() {
        return real;
    }

    public double getImaginaryValue() {
        return imaginary;
    }

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public ComplexNumber add(ComplexNumber complexNumber) {
        double newReal = this.real + complexNumber.real;
        double newImaginary = this.imaginary + complexNumber.imaginary;

        return new ComplexNumber(newReal, newImaginary);
    }

    public ComplexNumber multiply(ComplexNumber complexNumber) {
        double newReal = (this.real * complexNumber.real) - (this.imaginary * complexNumber.imaginary);
        double newImaginary = (this.real * complexNumber.imaginary) + (this.imaginary * complexNumber.real);

        return new ComplexNumber(newReal, newImaginary);

        // z1 = 7 + 3i
        // z2 = 6 + 2i
        // z1 * z2 = (7 + 3i) * (6 + 2i) = 42 + 14i + 18i + 6i^2, где i^2 = -1
        // z1 * z2 = 36 + 32i
    }
}
