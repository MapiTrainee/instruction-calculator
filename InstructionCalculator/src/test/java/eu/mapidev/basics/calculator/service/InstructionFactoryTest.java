package eu.mapidev.basics.calculator.service;

import eu.mapidev.basics.calculator.domain.Instruction;
import java.math.BigDecimal;
import org.junit.Before;
import org.junit.Test;

public class InstructionFactoryTest {

    private InstructionFactoryImpl factory;

    @Before
    public void setUp() {
	factory = new InstructionFactoryImpl();
    }

    @Test
    public void shouldCreateInstructionInstanceByStringName() {
	Instruction[] instructions = new Instruction[]{
	    factory.getInstance("add", BigDecimal.ONE),
	    factory.getInstance("subtract", BigDecimal.ONE),
	    factory.getInstance("multiply", BigDecimal.ONE),
	    factory.getInstance("divide", BigDecimal.ONE)
	};
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenInstructionIsUnrecognized() {
	Instruction instruction = factory.getInstance("none", BigDecimal.ONE);
    }

}
