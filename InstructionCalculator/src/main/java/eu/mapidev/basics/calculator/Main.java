package eu.mapidev.basics.calculator;

import eu.mapidev.basics.calculator.domain.Instruction;
import eu.mapidev.basics.calculator.service.InstructionFactoryImpl;
import eu.mapidev.basics.calculator.service.InstructionParser;
import eu.mapidev.basics.calculator.service.SimpleReader;
import java.io.File;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static final String USAGE_MESSAGE = "usage: (program) path_to_file";

    public static void main(String[] args) {
	if (args.length != 1) {
	    System.out.print(USAGE_MESSAGE);
	    return;
	}

	SimpleReader reader = new SimpleReader(new File(args[0]));
	LinkedList<String> lines = reader.readLines();
	
	InstructionParser parser = new InstructionParser(new InstructionFactoryImpl());
	BigDecimal initValue = parser.parseLineForApplyInstruction(lines.getLast());
	List<Instruction> instructions = parser.parseLines(lines.subList(0, lines.size() - 1));
	
	Calculator calculator = new Calculator(initValue);
	calculator.upload(instructions);
	BigDecimal resultValue = calculator.compute();
	
	System.out.print("Output: " + resultValue);
    }
}
