package eu.mapidev.basics.calculator.service;

import eu.mapidev.basics.calculator.domain.Addition;
import eu.mapidev.basics.calculator.domain.Division;
import eu.mapidev.basics.calculator.domain.Instruction;
import eu.mapidev.basics.calculator.domain.Multiplication;
import eu.mapidev.basics.calculator.domain.Subtraction;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class InstructionFactory {

    private Map<String, InstructionCreator> nameToCreator = new HashMap<>();

    public InstructionFactory() {
	nameToCreator.put("add", new AddCreator());
	nameToCreator.put("subtract", new SubtractCreator());
	nameToCreator.put("multiply", new MultiplyCreator());
	nameToCreator.put("divide", new DivisionCreator());
    }

    private interface InstructionCreator {

	public Instruction create(BigDecimal instructionValue);
    }

    private class AddCreator implements InstructionCreator {

	@Override
	public Instruction create(BigDecimal instructionValue) {
	    return new Addition(instructionValue);
	}
    }

    private class SubtractCreator implements InstructionCreator {

	@Override
	public Instruction create(BigDecimal instructionValue) {
	    return new Subtraction(instructionValue);
	}
    }

    private class MultiplyCreator implements InstructionCreator {

	@Override
	public Instruction create(BigDecimal instructionValue) {
	    return new Multiplication(instructionValue);
	}
    }

    private class DivisionCreator implements InstructionCreator {

	@Override
	public Instruction create(BigDecimal instructionValue) {
	    return new Division(instructionValue);
	}
    }

    public Instruction getInstance(String name, BigDecimal instructionValue) {
	if (!nameToCreator.containsKey(name)) {
	    throw new IllegalArgumentException("Incorrect instruction name: " + name);
	}
	return nameToCreator.get(name).create(instructionValue);
    }

}
