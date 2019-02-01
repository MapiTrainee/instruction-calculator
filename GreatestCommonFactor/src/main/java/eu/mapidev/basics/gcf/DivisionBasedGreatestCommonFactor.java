package eu.mapidev.basics.gcf;

import java.util.function.BinaryOperator;

public class DivisionBasedGreatestCommonFactor extends GreatestCommonFactor {

    public BinaryOperator<Integer> iterativeFinder() {
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

    public BinaryOperator<Integer> recursiveFinder() {
	return new BinaryOperator<Integer>() {

	    private int r;

	    @Override
	    public Integer apply(Integer a, Integer b) {
		validateInputValues(a, b);
		return find(a, b);
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
