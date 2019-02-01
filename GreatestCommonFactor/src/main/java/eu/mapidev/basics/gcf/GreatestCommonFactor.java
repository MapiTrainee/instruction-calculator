package eu.mapidev.basics.gcf;

import java.util.function.BinaryOperator;

public abstract class GreatestCommonFactor {

    public abstract BinaryOperator<Integer> iterativeFinder();

    public abstract BinaryOperator<Integer> recursiveFinder();

    protected void validateInputValues(Integer a, Integer b) throws IllegalArgumentException {
	if (a == null || b == null || a <= 0 || b <= 0) {
	    throw new IllegalArgumentException("Input numbers must be positive and not null!");
	}
    }

}
