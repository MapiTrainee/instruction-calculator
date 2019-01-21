package eu.mapidev.basics.missval;

public class MissingValueFinder {

    public static int naiveFindMissing(int... numbers) {
	int missingValue;
	for (missingValue = 0; missingValue < numbers.length; missingValue++) {
	    if (!containValue(numbers, missingValue)) {
		return missingValue;
	    }
	}
	return missingValue;
    }

    private static boolean containValue(int[] numbers, int missingValue) {
	for (int number : numbers) {
	    if (number == missingValue) {
		return true;
	    }
	}
	return false;
    }

    public static int memoryGreedyFindMissing(int... numbers) {
	boolean[] existedNumbers = new boolean[numbers.length + 1];

	for (int number : numbers) {
	    existedNumbers[number] = true;
	}

	int missingValue;
	for (missingValue = 0; missingValue < existedNumbers.length; missingValue++) {
	    if (!existedNumbers[missingValue]) {
		return missingValue;
	    }
	}
	return missingValue;
    }

}
