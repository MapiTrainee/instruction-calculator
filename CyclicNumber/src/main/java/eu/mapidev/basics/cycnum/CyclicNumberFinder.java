package eu.mapidev.basics.cycnum;

import java.math.BigInteger;

public class CyclicNumberFinder {

    public boolean isCyclicNumber(String input) {
	BigInteger number = new BigInteger(input);
	String doubledInput = input + input;
	int factor = 2;

	while (factor <= input.length()) {
	    BigInteger multipliedNumber = number.multiply(BigInteger.valueOf(factor));
	    if (!doubledInput.contains(multipliedNumber.toString())) {
		return false;
	    }
	    factor++;
	}

	return true;
    }

}
