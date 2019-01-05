package eu.mapidev.basics.calculator.domain;

import java.math.BigDecimal;

public class Addition extends Instruction {

    public Addition(BigDecimal instructionValue) {
	super(instructionValue);
    }

    @Override
    public BigDecimal apply(BigDecimal initValue) {
	return initValue.add(instructionValue);
    }
}
