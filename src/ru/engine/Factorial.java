package ru.engine;

/**
 * Created by Crow on 31.01.2016.
 */
public class Factorial {
    private Double result = 0.0d;

    private int recursiveMultiplication(int currentNumber) {
        if(currentNumber > 0) {
            result = result * currentNumber;
            recursiveMultiplication(currentNumber - 1);
        }

        return currentNumber;
    }

    public long multiplication(int number) {
        result = Double.valueOf(number);
        recursiveMultiplication(number - 1);
        return result.longValue();
    }
}
