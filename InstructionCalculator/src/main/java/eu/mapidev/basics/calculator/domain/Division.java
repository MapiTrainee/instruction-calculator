package eu.mapidev.basics.calculator.domain;

import java.math.BigDecimal;

public class Division extends Instruction {

    public Division(BigDecimal instructionValue) {
	super(instructionValue);
    }

    @Override
    public BigDecimal apply(BigDecimal initValue) {
	return initValue.divide(instructionValue);
    }

}
