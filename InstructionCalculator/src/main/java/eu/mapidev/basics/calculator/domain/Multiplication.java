package eu.mapidev.basics.calculator.domain;

import java.math.BigDecimal;

public class Multiplication extends Instruction {

    public Multiplication(BigDecimal instructionValue) {
	super(instructionValue);
    }

    @Override
    public BigDecimal apply(BigDecimal initValue) {
	return initValue.multiply(instructionValue);
    }
}
