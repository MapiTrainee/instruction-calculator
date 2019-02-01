package eu.mapidev.basics.gcf;

import java.util.function.BiFunction;

public class ExtendedEuclideanGreatestCommonFactor {
    
    public static BiFunction<Integer, Integer, Integer[]> recursiveFinder() {
	return new BiFunction<Integer, Integer, Integer[]>() {
	    private Integer[] p;
	    private Integer q;
	    
	    @Override
	    public Integer[] apply(Integer a, Integer b) {
		validateInputValues(a, b);
		return find(a, b);
	    }
	    
	    public Integer[] find(Integer a, Integer b) {
		if (b == 0) {
		    return new Integer[]{1, 0};
		} else {
		    p = find(b, a % b);
		    q = a / b;
		    return new Integer[]{p[1], p[0] - q * p[1]};
		}
	    }
	};
    }
    
    private static void validateInputValues(Integer a, Integer b) throws IllegalArgumentException {
	if (a == null || b == null || a <= 0 || b <= 0) {
	    throw new IllegalArgumentException("Input numbers must be positive and not null!");
	}
    }
    
    public static BiFunction<Integer, Integer, Integer[]> iterativeFinder() {
	return (a, b) -> {
	    validateInputValues(a, b);
	    int prevX = 1, prevY = 0;
	    int x = 0, y = 1;
	    int q, r, newX, newY;
	    
	    while (b != 0) {
		q = a / b;
		r = a % b;
		a = b;
		b = r;
		newX = prevX - q * x;
		newY = prevY - q * y;
		prevX = x;
		prevY = y;
		x = newX;
		y = newY;
	    }
	    return new Integer[]{prevX, prevY};
	};
    }
    
}
