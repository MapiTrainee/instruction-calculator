package eu.mapidev.basics.missval;

import static eu.mapidev.basics.missval.MissingValueFinder.memoryGreedyFindMissing;
import static eu.mapidev.basics.missval.MissingValueFinder.naiveFindMissing;
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

}
