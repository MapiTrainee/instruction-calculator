package eu.mapidev.basics.calculator.domain;

import java.math.BigDecimal;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

public class InstructionTest {

    @Test
    public void shouldAllowToCreateFourDefaultInstructionsWithInitValues() {
	Instruction[] instructions = new Instruction[]{
	    new Addition(BigDecimal.TEN),
	    new Subtraction(BigDecimal.TEN),
	    new Division(BigDecimal.TEN),
	    new Multiplication(BigDecimal.TEN)
	};
    }

    @Test
    public void shouldAddInitToInstructionValueForAdditionalInstruction() {
	Instruction add = new Addition(BigDecimal.ONE);
	BigDecimal expectedResult = add.apply(BigDecimal.ONE);
	assertThat(expectedResult, is(BigDecimal.valueOf(2)));
    }

    @Test
    public void shouldSubtractInstructionFromInitValueForSubtractionInstruction() {
	Instruction subtract = new Subtraction(BigDecimal.ONE);
	BigDecimal expectedResult = subtract.apply(BigDecimal.TEN);
	assertThat(expectedResult, is(BigDecimal.valueOf(9)));
    }

    @Test
    public void shouldMultiplyInitByInstructionValueForMultiplicationInstruction() {
	Instruction multiply = new Multiplication(BigDecimal.TEN);
	BigDecimal expectedResult = multiply.apply(BigDecimal.TEN);
	assertThat(expectedResult, is(BigDecimal.valueOf(100)));
    }

    @Test
    public void shouldDivideInitByInstructionValueForDivisionInstruction() {
	Instruction divide = new Division(BigDecimal.valueOf(2));
	BigDecimal expectedResult = divide.apply(BigDecimal.TEN);
	assertThat(expectedResult, is(BigDecimal.valueOf(5)));
    }

}
