package eu.mapidev.basics.gcf;

import java.util.function.BiFunction;

public class ExtendedEuclideanGreatestCommonFactor {

    public static BiFunction<Integer, Integer, Integer[]> recursiveFinder() {
	return new BiFunction<Integer, Integer, Integer[]>() {
	    private Integer[] p = {0, 0};

	    @Override
	    public Integer[] apply(Integer a, Integer b) {
		if (b == 0) {
		    return new Integer[]{1, 0};
		} else {
		    p = apply(b, a % b);
		    Integer q = a / b;
		    return new Integer[]{p[1], p[0] - q * p[1]};
		}
	    }
	};
    }

    public static BiFunction<Integer, Integer, Integer[]> iterativeFinder() {
	throw new UnsupportedOperationException("Not implemented yet!");
    }

}
