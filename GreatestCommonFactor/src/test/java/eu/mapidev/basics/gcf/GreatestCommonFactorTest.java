package eu.mapidev.basics.gcf;

import java.util.Arrays;
import java.util.Collection;
import java.util.function.BinaryOperator;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class GreatestCommonFactorTest {

    @Parameter(0)
    public Integer inputA;
    @Parameter(1)
    public Integer inputB;
    @Parameter(2)
    public Integer expectedFactor;
    @Parameter(3)
    public Class<? extends Exception> expectedException;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Parameters
    public static Collection data() {
	return Arrays.asList(new Object[][]{
	    {null, 1, -1, IllegalArgumentException.class},
	    {1, null, -1, IllegalArgumentException.class},
	    {-1, 1, -1, IllegalArgumentException.class},
	    {1, -1, -1, IllegalArgumentException.class},
	    {1, 0, -1, IllegalArgumentException.class},
	    {0, 1, 0, IllegalArgumentException.class},
	    {1, 1, 1, null},
	    {4, 2, 2, null},
	    {2, 4, 2, null},
	    {20, 35, 5, null},
	    {35, 20, 5, null},
	    {1071, 462, 21, null},
	    {462, 1071, 21, null},}
	);

    }

    @Test
    public void iterativeGCFShouldObtainResultsAccordingToData() {
	if (expectedException != null) {
	    thrown.expect(expectedException);
	}
	BinaryOperator<Integer> finder = GreatestCommonFactor.iterativeFinder();
	assertThat(finder.apply(inputA, inputB), equalTo(expectedFactor));
    }

    @Test
    public void recursiveGCFShouldObtainResultsAccordingToData() {
	if (expectedException != null) {
	    thrown.expect(expectedException);
	}
	BinaryOperator<Integer> finder = GreatestCommonFactor.recursiveFinder();
	assertThat(finder.apply(inputA, inputB), equalTo(expectedFactor));
    }

}
