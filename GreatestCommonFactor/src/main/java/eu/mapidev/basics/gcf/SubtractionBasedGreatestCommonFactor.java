package eu.mapidev.basics.gcf;

import java.util.function.BinaryOperator;

public class SubtractionBasedGreatestCommonFactor extends GreatestCommonFactor {

    @Override
    public BinaryOperator<Integer> iterativeFinder() {
	return (a, b) -> {
	    validateInputValues(a, b);

	    while (a != b) {
		if (a > b) {
		    a = a - b;
		} else {
		    b = b - a;
		}
	    }
	    return a;
	};
    }

    @Override
    public BinaryOperator<Integer> recursiveFinder() {
	return new BinaryOperator<Integer>() {
	    @Override
	    public Integer apply(Integer a, Integer b) {
		validateInputValues(a, b);
		return find(a, b);
	    }

	    private Integer find(Integer a, Integer b) {
		if (a == b) {
		    return a;
		} else if (a > b) {
		    return find(a - b, b);
		} else {
		    return find(a, b - a);
		}
	    }
	};
    }

}
