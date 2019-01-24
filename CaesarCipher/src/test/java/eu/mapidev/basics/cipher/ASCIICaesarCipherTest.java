package eu.mapidev.basics.cipher;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.collection.IsArrayContainingInOrder.arrayContaining;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;

public class ASCIICaesarCipherTest {

    private CaesarCipher caesarCipher;

    @Before
    public void setUp() {
	caesarCipher = new ASCIICaesarCipher();
    }

    @Test
    public void shouldNotEncryptWhenKeyIs0() {
	String plaintext = "ABCabc";
	int key = 0;
	String secret = caesarCipher.encrypt(plaintext, key);
	assertThat(secret, is(plaintext));
    }

    @Test
    public void shouldEncryptABCabcToBCDbcdWhenKeyIs1() {
	String plaintext = "ABCabc";
	int key = 1;
	String secret = caesarCipher.encrypt(plaintext, key);
	assertThat(secret, is("BCDbcd"));
    }

    @Test
    public void shouldEncryptABCabcToZABzabWhenKeyIs25() {
	String plaintext = "ABCabc";
	int key = 25;
	String secret = caesarCipher.encrypt(plaintext, key);
	assertThat(secret, is("ZABzab"));
    }

    @Test
    public void shouldEncryptABCabcToCDEcdeWhenKeyIs28() {
	String plaintext = "ABCabc";
	int key = 28;
	String secret = caesarCipher.encrypt(plaintext, key);
	assertThat(secret, is("CDEcde"));
    }

    @Test
    public void shouldNotDecryptWhenKeyIs0() {
	String secret = "ABCabc";
	int key = 0;
	String plaintext = caesarCipher.decrypt(secret, key);
	assertThat(plaintext, is(secret));
    }

    @Test
    public void shouldDecryptBCDbcdToABCabcWhenKeyIs1() {
	String secret = "BCDbcd";
	int key = 1;
	String plaintext = caesarCipher.decrypt(secret, key);
	assertThat(plaintext, is("ABCabc"));
    }

    @Test
    public void shouldDecryptZABzabToABCabcWhenKeyIs25() {
	String secret = "ZABzab";
	int key = 25;
	String plaintext = caesarCipher.decrypt(secret, key);
	assertThat(plaintext, is("ABCabc"));
    }

    @Test
    public void shouldDecryptCDEcdeToABCabcWhenKeyIs28() {
	String secret = "CDEcde";
	int key = 28;
	String plaintext = caesarCipher.decrypt(secret, key);
	assertThat(plaintext, is("ABCabc"));
    }

}
