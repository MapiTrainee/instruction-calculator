package eu.mapidev.basics.calculator.domain;

import java.math.BigDecimal;

public abstract class Instruction {

    protected BigDecimal instructionValue;

    public Instruction(BigDecimal instructionValue) {
	this.instructionValue = instructionValue;
    }

    public abstract BigDecimal apply(BigDecimal initValue);
}
