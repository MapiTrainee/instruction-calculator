package eu.mapidev.basics.calculator.service;

import eu.mapidev.basics.calculator.domain.Instruction;
import java.math.BigDecimal;

public interface InstructionFactory {

    Instruction getInstance(String name, BigDecimal instructionValue);
}
