package eu.mapidev.basics.task.wega;

import java.util.Arrays;
import java.util.List;

public class SignalFinder {

    private final List<String> signals;
    private boolean[] visitedCharacters = new boolean[26];
    private int theLargestNumberOfDifferentCharacters;
    private String theMessageWithTheLargestNumberOfDifferentCharacters;

    public SignalFinder(List<String> signals) {
	this.signals = signals;
    }

    public String readSecretMessage() {
	StringBuilder sb = new StringBuilder();
	for (int messageIndex = 40; messageIndex <= signals.size(); messageIndex += 40) {
	    String signal = signals.get(messageIndex - 1);
	    char tenthCharacter = signal.charAt(9);
	    sb.append(tenthCharacter);
	}
	return sb.toString();
    }

    public String findMessageWithTheLargetstNumberOfDifferentCharacters() {
	theLargestNumberOfDifferentCharacters = Integer.MIN_VALUE;
	theMessageWithTheLargestNumberOfDifferentCharacters = null;

	for (String signal : signals) {
	    Arrays.fill(visitedCharacters, false);
	    visitAllCharactersOfString(signal);
	    int visitedCharactersCounter = getVisitedCharactersCounter();
	    if (visitedCharactersCounter > theLargestNumberOfDifferentCharacters) {
		theMessageWithTheLargestNumberOfDifferentCharacters = signal;
		theLargestNumberOfDifferentCharacters = visitedCharactersCounter;
	    }
	}
	return theMessageWithTheLargestNumberOfDifferentCharacters;
    }

    private int getVisitedCharactersCounter() {
	int counter = 0;
	for (int i = 0; i < visitedCharacters.length; i++) {
	    if (visitedCharacters[i]) {
		counter++;
	    }
	}
	return counter;
    }

    private void visitAllCharactersOfString(String input) {
	char[] characters = input.toCharArray();
	for (int i = 0; i < characters.length; i++) {
	    visitedCharacters[characters[i] - 65] = true;
	}
    }
}
