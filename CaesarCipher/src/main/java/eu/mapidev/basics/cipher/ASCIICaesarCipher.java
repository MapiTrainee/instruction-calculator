package eu.mapidev.basics.cipher;

import javax.xml.stream.events.Characters;

public class ASCIICaesarCipher implements CaesarCipher {

    @Override
    public String encrypt(String plaintext, int key) {
	key = key % 26;
	char[] input = plaintext.toCharArray();
	for (int i = 0; i < input.length; i++) {
	    boolean isLowerCases = false;
	    if (Character.isLowerCase(input[i])) {
		isLowerCases = true;
		input[i] = Character.toUpperCase(input[i]);
	    }
	    char encoded;
	    if ((input[i] + key) > 90) {
		int shift = input[i] + key - 90;
		encoded = (char) (64 + shift);
	    } else {
		encoded = (char) (input[i] + key);
	    }
	    input[i] = isLowerCases ? Character.toLowerCase(encoded) : encoded;
	}
	return new String(input);
    }

    @Override
    public String decrypt(String secret, int key) {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
