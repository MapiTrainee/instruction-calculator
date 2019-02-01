package eu.mapidev.basics.gcf;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

public class ExtendedEuclideanGreatestCommonFactor extends GreatestCommonFactor {

    public BiFunction<Integer, Integer, Integer[]> recursiveExtendedFinder() {
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

    public BiFunction<Integer, Integer, Integer[]> iterativeExtendedFinder() {
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

    @Override
    public BinaryOperator<Integer> iterativeFinder() {
	return (a, b) -> {
	    Integer[] p = iterativeExtendedFinder().apply(a, b);
	    return a * p[0] + b * p[1];
	};
    }

    @Override
    public BinaryOperator<Integer> recursiveFinder() {
	return (a, b) -> {
	    Integer[] p = recursiveExtendedFinder().apply(a, b);
	    return a * p[0] + b * p[1];
	};
    }

}
