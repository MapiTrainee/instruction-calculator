package eu.mapidev.basics.calculator;

import eu.mapidev.basics.calculator.domain.Instruction;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

public class Calculator {

    private BigDecimal initValue;
    private final List<Instruction> instructions = new LinkedList<>();

    public Calculator(BigDecimal initValue) {
	this.initValue = initValue;
    }

    public void setInitValue(BigDecimal initValue) {
	this.initValue = initValue;
    }

    public void upload(List<Instruction> instructions) {
	this.instructions.addAll(instructions);
    }

    public BigDecimal compute() {
	BigDecimal currentValue = initValue;
	for (Instruction instruction : instructions) {
	    currentValue = instruction.apply(currentValue);
	}
	return currentValue;
    }

}
