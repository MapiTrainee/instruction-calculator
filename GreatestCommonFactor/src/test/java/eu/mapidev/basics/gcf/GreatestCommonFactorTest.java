package eu.mapidev.basics.gcf;

import java.util.function.BinaryOperator;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class GreatestCommonFactorTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void iterativeGCFShouldReturnTwoWhenInputContainsFourAndTwo() {
	int input[] = {4, 2};
	BinaryOperator<Integer> finder = GreatestCommonFactor.iterativeFinder();
	int factor = finder.apply(input[0], input[1]);
	assertThat(factor, equalTo(2));
    }

    @Test
    public void iterativeGCFShouldReturnTwoWhenInputContainsTwoAndFour() {
	int input[] = {2, 4};
	BinaryOperator<Integer> finder = GreatestCommonFactor.iterativeFinder();
	int factor = finder.apply(input[0], input[1]);
	assertThat(factor, equalTo(2));
    }

    @Test
    public void iterativeGCFShouldThrowExceptionWhenInputIsNegative() {
	BinaryOperator<Integer> finder = GreatestCommonFactor.iterativeFinder();
	thrown.expect(IllegalArgumentException.class);
	finder.apply(-1, -1);
    }

    @Test
    public void recursiveGCFShouldReturnTwoWhenInputContainsFourAndTwo() {
	int input[] = {4, 2};
	BinaryOperator<Integer> finder = GreatestCommonFactor.recursiveFinder();
	int factor = finder.apply(input[0], input[1]);
	assertThat(factor, equalTo(2));
    }

    @Test
    public void recursiveGCFShouldReturnTwoWhenInputContainsTwoAndFour() {
	int input[] = {2, 4};
	BinaryOperator<Integer> finder = GreatestCommonFactor.recursiveFinder();
	int factor = finder.apply(input[0], input[1]);
	assertThat(factor, equalTo(2));
    }

    @Test
    public void recursiveGCFShouldThrowExceptionWhenInputIsNegative() {
	BinaryOperator<Integer> finder = GreatestCommonFactor.recursiveFinder();
	thrown.expect(IllegalArgumentException.class);
	finder.apply(-1, -1);
    }

}
