package eu.mapidev.basics.task.wega;

import java.util.ArrayList;
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
	    int visitedCharactersCounter = countVisitedCharacters();
	    if (visitedCharactersCounter > theLargestNumberOfDifferentCharacters) {
		theMessageWithTheLargestNumberOfDifferentCharacters = signal;
		theLargestNumberOfDifferentCharacters = visitedCharactersCounter;
	    }
	}
	return theMessageWithTheLargestNumberOfDifferentCharacters;
    }

    private int countVisitedCharacters() {
	int counter = 0;
	for (boolean visitedCharacter : visitedCharacters) {
	    if (visitedCharacter) {
		counter++;
	    }
	}
	return counter;
    }

    private void visitAllCharactersOfString(String input) {
	char[] letters = input.toCharArray();
	for (char letter : letters) {
	    visitedCharacters[letter - 65] = true;
	}
    }

    public List<String> findMessagesWithCharactersDistanceUpperLimit(int limit) {
	List<String> messages = new ArrayList<>();
	for (String signal : signals) {
	    char[] letters = signal.toCharArray();

	    int characterMinValue = 90;
	    int characterMaxValue = 65;
	    for (char character : letters) {
		if (character > characterMaxValue) {
		    characterMaxValue = character;
		} else if (character < characterMinValue) {
		    characterMinValue = character;
		}
	    }
	    int distance = characterMaxValue - characterMinValue;
	    if (distance <= limit) {
		messages.add(signal);
	    }
	}
	return messages;
    }
}
