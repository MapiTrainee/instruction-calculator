package eu.mapidev.basics.gcf;

import java.util.function.BinaryOperator;

public class GreatestCommonFactor {

    public static BinaryOperator<Integer> iterativeFinder() {
	return (a, b) -> {
	    validateInputValues(a, b);

	    int r;
	    while ((r = a % b) != 0) {
		a = b;
		b = r;
	    }
	    return b;
	};
    }

    private static void validateInputValues(Integer a, Integer b) throws IllegalArgumentException {
	if (a < 0 || b <= 0 || a == null || b == null) {
	    throw new IllegalArgumentException("Input numbers cannot be negative or null!");
	}
    }

    public static BinaryOperator<Integer> recursiveFinder() {
	return new BinaryOperator<Integer>() {

	    private int r;
	    
	    @Override
	    public Integer apply(Integer a, Integer b) {
		validateInputValues(a, b);
		
		return find(a,b);
	    }

	    public Integer find(Integer a, Integer b) {
		if ((r = (a % b)) == 0) {
		    return b;
		} else {
		    return apply(b, r);
		}
	    }
	};
    }

}
