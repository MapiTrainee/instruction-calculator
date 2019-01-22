package eu.mapidev.basics.missval;

import static eu.mapidev.basics.missval.MissingValueFinder.arithmeticFindMissing;
import static eu.mapidev.basics.missval.MissingValueFinder.memoryGreedyFindMissing;
import static eu.mapidev.basics.missval.MissingValueFinder.naiveFindMissing;
import static eu.mapidev.basics.missval.MissingValueFinder.sortedNaiveFindMissing;
import static org.hamcrest.CoreMatchers.equalTo;
import org.junit.Test;
import static org.junit.Assert.*;

public class MissingValueFinderTest {

    @Test
    public void shouldFindMissingValueForEmptyArrayNaive() {
	int[] emptyArray = new int[0];
	assertThat(naiveFindMissing(emptyArray), equalTo(0));
    }

    @Test
    public void shouldFindMissingValneueForOneElementArrayNaive() {
	assertThat(naiveFindMissing(1), equalTo(0));
	assertThat(naiveFindMissing(0), equalTo(1));
    }

    @Test
    public void shouldFindMissingValueIfItsFirstElementInArrayNaive() {
	int[] firstMissingElementArray = {3, 4, 2, 1};
	assertThat(naiveFindMissing(firstMissingElementArray), equalTo(0));
    }

    @Test
    public void shouldFindMissingValueIfItsTheLastElementInArrayNaive() {
	int[] lastMissingElementArray = {0, 2, 3, 4, 1};
	assertThat(naiveFindMissing(lastMissingElementArray), equalTo(5));
    }

    @Test
    public void shouldFindMissingValueInASampleArrayNaive() {
	int[] sampleArray = {0, 2, 3, 4};
	assertThat(naiveFindMissing(sampleArray), equalTo(1));
    }

    @Test
    public void shouldFindMissingValueForEmptyArrayMemoryGreedy() {
	int[] emptyArray = new int[0];
	assertThat(memoryGreedyFindMissing(emptyArray), equalTo(0));
    }

    @Test
    public void shouldFindMissingValneueForOneElementArrayMemoryGreedy() {
	assertThat(memoryGreedyFindMissing(1), equalTo(0));
	assertThat(memoryGreedyFindMissing(0), equalTo(1));
    }

    @Test
    public void shouldFindMissingValueIfItsFirstElementInArrayMemoryGreedy() {
	int[] firstMissingElementArray = {3, 4, 2, 1};
	assertThat(memoryGreedyFindMissing(firstMissingElementArray), equalTo(0));
    }

    @Test
    public void shouldFindMissingValueIfItsTheLastElementInArrayMemoryGreedy() {
	int[] lastMissingElementArray = {0, 2, 3, 4, 1};
	assertThat(memoryGreedyFindMissing(lastMissingElementArray), equalTo(5));
    }

    @Test
    public void shouldFindMissingValueInASampleArrayMemoryGreedy() {
	int[] sampleArray = {0, 2, 3, 4};
	assertThat(memoryGreedyFindMissing(sampleArray), equalTo(1));
    }
    
    @Test
    public void shouldFindMissingValueForEmptyArraySortedNaive() {
	int[] emptyArray = new int[0];
	assertThat(sortedNaiveFindMissing(emptyArray), equalTo(0));
    }

    @Test
    public void shouldFindMissingValneueForOneElementArraySortedNaive() {
	assertThat(sortedNaiveFindMissing(1), equalTo(0));
	assertThat(sortedNaiveFindMissing(0), equalTo(1));
    }

    @Test
    public void shouldFindMissingValueIfItsFirstElementInArraySortedNaive() {
	int[] firstMissingElementArray = {3, 4, 2, 1};
	assertThat(sortedNaiveFindMissing(firstMissingElementArray), equalTo(0));
    }

    @Test
    public void shouldFindMissingValueIfItsTheLastElementInArraySortedNaive() {
	int[] lastMissingElementArray = {0, 2, 3, 4, 1};
	assertThat(sortedNaiveFindMissing(lastMissingElementArray), equalTo(5));
    }

    @Test
    public void shouldFindMissingValueInASampleArraySortedNaive() {
	int[] sampleArray = {0, 2, 3, 4};
	assertThat(sortedNaiveFindMissing(sampleArray), equalTo(1));
    }
    
    @Test
    public void shouldFindMissingValueForEmptyArrayArithmetic() {
	int[] emptyArray = new int[0];
	assertThat(arithmeticFindMissing(emptyArray), equalTo(0));
    }

    @Test
    public void shouldFindMissingValneueForOneElementArrayArithmetic() {
	assertThat(arithmeticFindMissing(1), equalTo(0));
	assertThat(arithmeticFindMissing(0), equalTo(1));
    }

    @Test
    public void shouldFindMissingValueIfItsFirstElementInArrayArithmetic() {
	int[] firstMissingElementArray = {3, 4, 2, 1};
	assertThat(arithmeticFindMissing(firstMissingElementArray), equalTo(0));
    }

    @Test
    public void shouldFindMissingValueIfItsTheLastElementInArrayArithmetic() {
	int[] lastMissingElementArray = {0, 2, 3, 4, 1};
	assertThat(arithmeticFindMissing(lastMissingElementArray), equalTo(5));
    }

    @Test
    public void shouldFindMissingValueInASampleArrayArithmetic() {
	int[] sampleArray = {0, 2, 3, 4};
	assertThat(arithmeticFindMissing(sampleArray), equalTo(1));
    }

}
