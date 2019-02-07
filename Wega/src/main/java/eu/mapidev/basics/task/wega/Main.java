package eu.mapidev.basics.task.wega;

import java.io.File;
import java.util.List;

public class Main {
    
    public static void main(String[] args) {
	ClassLoader cl = ClassLoader.getSystemClassLoader();
	SimpleLineReader reader = new SimpleLineReader(new File(cl.getResource("signals.txt").getPath()));
	SignalFinder sf = new SignalFinder(reader.readAll());
	String secretMesage = sf.readSecretMessage();
	String messageWithTheLargestNumber = sf.findMessageWithTheLargestNumberOfDifferentCharacters();
	List<String> messages = sf.findMessagesWithCharactersDistanceUpperLimit(10);
	
	System.out.println("<=== FIRST QUESTION ==>");
	System.out.println(secretMesage);
	
	System.out.println("<=== SECOND QUESTION ==>");
	System.out.println(messageWithTheLargestNumber + " " + sf.countDifferentCharactersOfString(messageWithTheLargestNumber));
	
	System.out.println("<=== THIRD QUESTION ==>");
	for (String message : messages) {
	    System.out.println(message);
	}
    }
}
