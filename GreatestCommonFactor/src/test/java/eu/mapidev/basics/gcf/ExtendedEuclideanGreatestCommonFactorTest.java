package eu.mapidev.basics.gcf;

import java.util.function.BiFunction;
import static org.hamcrest.Matchers.arrayContaining;
import static org.junit.Assert.assertThat;
import org.junit.Test;

public class ExtendedEuclideanGreatestCommonFactorTest {

    @Test
    public void recursiveFinderShouldReturnCorrectCoefficientsForThisExample() {
	Integer a = 188;
	Integer b = 12;
	Integer[] expectedCoefficents = {-1, 16};

	BiFunction<Integer, Integer, Integer[]> finder = ExtendedEuclideanGreatestCommonFactor.recursiveFinder();
	assertThat(finder.apply(a, b), arrayContaining(expectedCoefficents));
    }
}
