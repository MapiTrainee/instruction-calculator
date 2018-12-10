package eu.mapidev.basics.calculator.service;

import eu.mapidev.basics.calculator.domain.Instruction;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.Before;

public class InstructionParserTest {

    private InstructionParser parser;

    @Before
    public void setUp() {
	parser = new InstructionParser(new InstructionFactory());
    }

    @Test
    public void shouldParseLineOfTextToInstruction() {
	String inputLine = "add 1";
	Instruction instruction = parser.parseLine(inputLine);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenLineIsIncorrect() {
	String inputLine = "xyz";
	Instruction instruction = parser.parseLine(inputLine);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenUnrecognizedOperation() {
	String inputLine = "none 1";
	Instruction instruction = parser.parseLine(inputLine);
    }

    @Test
    public void shouldAllowToParseManyLines() {
	String[] inputLines = {"add 20", "add 2", "divide 10", "subtract 1"};
	List<Instruction> instructions = parser.parseLines(Arrays.asList(inputLines));
	assertThat(instructions.isEmpty(), is(false));
    }

    @Test
    public void shouldParseApplyOperationToBigDecimal() {
	String inputLine = "apply 1";
	BigDecimal expectedValue = parser.parseApplyInstruction(inputLine);
	assertThat(expectedValue, is(BigDecimal.ONE));
    }

}
