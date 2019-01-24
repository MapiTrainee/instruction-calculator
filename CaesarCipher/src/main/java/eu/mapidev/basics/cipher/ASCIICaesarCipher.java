package eu.mapidev.basics.cipher;

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
	key = key % 26;
	char[] input = secret.toCharArray();
	for (int i = 0; i < input.length; i++) {
	    boolean isLowerCases = false;
	    if (Character.isLowerCase(input[i])) {
		isLowerCases = true;
		input[i] = Character.toUpperCase(input[i]);
	    }
	    char encoded;
	    if ((input[i] - key) < 65) {
		int shift = 64 - (input[i] - key);
		encoded = (char) (90 - shift);
	    } else {
		encoded = (char) (input[i] - key);
	    }
	    input[i] = isLowerCases ? Character.toLowerCase(encoded) : encoded;
	}
	return new String(input);
    }

}
