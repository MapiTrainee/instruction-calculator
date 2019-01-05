package eu.mapidev.basics.calculator;

import eu.mapidev.basics.calculator.domain.Addition;
import eu.mapidev.basics.calculator.domain.Division;
import eu.mapidev.basics.calculator.domain.Instruction;
import eu.mapidev.basics.calculator.domain.Multiplication;
import eu.mapidev.basics.calculator.domain.Subtraction;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

    private Instruction[] instructions;
    private Calculator calculator;
    private BigDecimal initValue;

    @Before
    public void setUp() {
	initValue = BigDecimal.TEN;
	calculator = new Calculator(initValue);
	instructions = new Instruction[]{
	    new Addition(BigDecimal.ONE),
	    new Subtraction(BigDecimal.ONE),
	    new Multiplication(BigDecimal.ONE),
	    new Division(BigDecimal.ONE)
	};
    }

    @Test
    public void shouldBeAbleToLoadInstructions() {
	calculator.upload(Arrays.asList(instructions));
    }

    @Test
    public void shouldProcessAllInstructionsForInitialValue() {
	calculator.upload(Arrays.asList(instructions));
	calculator.compute();
    }

    @Test
    public void shouldReturnInitialValueWhenIsZeroInstructions() {
	BigDecimal actualResult = calculator.compute();
	assertThat(actualResult, is(initValue));
    }

    @Test
    public void shouldAdd10ToInitialValue() {
	Instruction instruction = new Addition(BigDecimal.TEN);
	calculator.upload(Collections.singletonList(instruction));
	BigDecimal actualResult = calculator.compute();
	assertThat(actualResult, equalTo(BigDecimal.valueOf(20)));
    }

    @Test
    public void shouldSubtract10FromInitialValue() {
	Instruction instruction = new Subtraction(BigDecimal.TEN);
	calculator.upload(Collections.singletonList(instruction));
	BigDecimal actualResult = calculator.compute();
	assertThat(actualResult, equalTo(BigDecimal.ZERO));
    }

    @Test
    public void shouldMuliplyInitialValueBy10() {
	Instruction instruction = new Multiplication(BigDecimal.TEN);
	calculator.upload(Collections.singletonList(instruction));
	BigDecimal actualResult = calculator.compute();
	assertThat(actualResult, equalTo(BigDecimal.valueOf(100)));
    }

    @Test
    public void shouldDivideInitialValueBy10() {
	Instruction instruction = new Division(BigDecimal.TEN);
	calculator.upload(Collections.singletonList(instruction));
	BigDecimal actualResult = calculator.compute();
	assertThat(actualResult, equalTo(BigDecimal.ONE));
    }
}
