package com.example.task03;

public class Task03Main {
    public static void main(String[] args) {
        ComplexNumber number1 = new ComplexNumber(7, 3);
        ComplexNumber number2 = new ComplexNumber(6, 2);

        ComplexNumber sum = number1.add(number2);
        ComplexNumber prod = number1.multiply(number2);

        System.out.printf("Сумма: (%g, %g)%nПроизведение: (%g, %g)%n", sum.getRealValue(), sum.getImaginaryValue(), prod.getRealValue(), prod.getImaginaryValue());
    }
}
