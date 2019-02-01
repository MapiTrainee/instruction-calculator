package eu.mapidev.basics.gcf;

import java.util.Arrays;
import java.util.Collection;
import java.util.function.BiFunction;
import static org.hamcrest.Matchers.arrayContaining;
import static org.junit.Assert.assertThat;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class ExtendedEuclideanGreatestCommonFactorTest {

    @Parameterized.Parameter(0)
    public Integer inputA;
    @Parameterized.Parameter(1)
    public Integer inputB;
    @Parameterized.Parameter(2)
    public Integer[] expectedCoefficients;
    @Parameterized.Parameter(3)
    public Class<? extends Exception> expectedException;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Parameterized.Parameters
    public static Collection data() {
	return Arrays.asList(new Object[][]{
	    {null, 1, null, IllegalArgumentException.class},
	    {1, null, null, IllegalArgumentException.class},
	    {-1, 1, null, IllegalArgumentException.class},
	    {1, -1, null, IllegalArgumentException.class},
	    {1, 0, null, IllegalArgumentException.class},
	    {0, 1, null, IllegalArgumentException.class},
	    {1, 1, new Integer[]{0, 1}, null},
	    {188, 12, new Integer[]{-1, 16}, null},
	    {12, 188, new Integer[]{16, -1}, null},
	    {30, 20, new Integer[]{1, -1}, null},
	    {20, 30, new Integer[]{-1, 1}, null}
	});

    }

    @Test
    public void recursiveFinderShouldReturnExpectedCoefficientsAccordingToData() {
	if (expectedException != null) {
	    thrown.expect(expectedException);
	}
	BiFunction<Integer, Integer, Integer[]> finder = ExtendedEuclideanGreatestCommonFactor.recursiveFinder();
	assertThat(finder.apply(inputA, inputB), arrayContaining(expectedCoefficients));
    }

    @Test
    public void iterativeFinderShouldReturnExpectedCoefficientsAccordingToData() {
	if (expectedException != null) {
	    thrown.expect(expectedException);
	}
	BiFunction<Integer, Integer, Integer[]> finder = ExtendedEuclideanGreatestCommonFactor.iterativeFinder();
	assertThat(finder.apply(inputA, inputB), arrayContaining(expectedCoefficients));
    }
}
