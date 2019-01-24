package eu.mapidev.basics.cipher;

public class ASCIICaesarCipher implements CaesarCipher {

    private CharacterLimit limit = CharacterLimit.UPPERCASE;

    @Override
    public String encrypt(String plaintext, int key) {
	key = key % 26;
	char[] letters = plaintext.toCharArray();
	for (int letterIndex = 0; letterIndex < letters.length; letterIndex++) {
	    applyLimitsByLetterCase(letters[letterIndex]);
	    letters[letterIndex] = getShiftedLetter(letters[letterIndex], key);
	}
	return new String(letters);
    }

    private char getShiftedLetter(int letterCode, int key) {
	if ((letterCode + key) > limit.upper) {
	    int over = (letterCode + key) - limit.upper;
	    return (char) (limit.lower - 1 + over);
	} else if ((letterCode + key) < limit.lower) {
	    int under = limit.lower - (letterCode + key);
	    return (char) (limit.upper + 1 - under);
	} else {
	    return (char) (letterCode + key);
	}
    }

    @Override
    public String decrypt(String secret, int key) {
	return encrypt(secret, -key);
    }

    private void applyLimitsByLetterCase(char letter) {
	if (Character.isLowerCase(letter)) {
	    limit = CharacterLimit.LOWERCASE;
	} else {
	    limit = CharacterLimit.UPPERCASE;
	}
    }

    private enum CharacterLimit {
	LOWERCASE(97, 122),
	UPPERCASE(65, 90);

	private int lower;
	private int upper;

	private CharacterLimit(int lower, int upper) {
	    this.lower = lower;
	    this.upper = upper;
	}

	public int getLower() {
	    return lower;
	}

	public int getUpper() {
	    return upper;
	}
    }

}
