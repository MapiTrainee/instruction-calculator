package eu.mapidev.basics.calculator.domain;

import java.math.BigDecimal;

public class Subtraction extends Instruction {

    public Subtraction(BigDecimal instructionValue) {
	super(instructionValue);
    }

    @Override
    public BigDecimal apply(BigDecimal initValue) {
	return initValue.subtract(instructionValue);
    }
    
}
