package eu.mapidev.basics.cipher;

public interface CaesarCipher {

    public String encrypt(String plaintext, int key);

    public String decrypt(String secret, int key);
}
