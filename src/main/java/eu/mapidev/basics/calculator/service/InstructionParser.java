package eu.mapidev.basics.calculator.service;

import eu.mapidev.basics.calculator.domain.Instruction;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

public class InstructionParser {

    private final InstructionFactory factory;

    public InstructionParser(InstructionFactory factory) {
	this.factory = factory;
    }

    public Instruction parseLine(String line) {
	String[] tokens = prepareTokens(line);
	return factory.getInstance(tokens[0].toLowerCase(), new BigDecimal(tokens[1]));
    }

    private String[] prepareTokens(String line) {
	String[] tokens = line.split(" ");
	if (tokens.length != 2) {
	    throw new IllegalArgumentException("This line: '" + line + "' should contain two elements!");
	}
	return tokens;
    }

    public List<Instruction> parseLines(List<String> lines) {
	List<Instruction> instructions = new LinkedList<>();
	for (String line : lines) {
	    instructions.add(parseLine(line));
	}
	return instructions;
    }

    public BigDecimal parseApplyInstruction(String line) {
	String[] tokens = prepareTokens(line);
	if ("apply".equalsIgnoreCase(tokens[0])) {
	    return new BigDecimal(tokens[1]);
	}
	throw new IllegalArgumentException("This line: '" + line + "' is NOT apply instruction!");
    }

}
