package eu.mapidev.basics.task.wega;

import java.util.List;

public class SignalFinder {

    private final List<String> signals;

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
}
