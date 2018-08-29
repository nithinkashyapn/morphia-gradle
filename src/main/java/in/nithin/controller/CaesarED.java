package in.nithin.controller;

public class CaesarED {

    // Character map
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    // Encryption
    public static String encrypt(String message, int offset){
        String plaintext = message.toLowerCase();
        String ciphertext = "";
        for (int i = 0; i < plaintext.length(); i++)
        {
            int charPosition = ALPHABET.indexOf(plaintext.charAt(i));
            int keyVal = (offset + charPosition) % 26;
            char replaceVal = ALPHABET.charAt(keyVal);
            ciphertext += replaceVal;
        }

        return ciphertext;
    }

    // Decryption
    public static String decrypt(String ciphertext, int offset)
    {
        ciphertext = ciphertext.toLowerCase();
        String plaintext = "";
        for (int i = 0; i < ciphertext.length(); i++)
        {
            int charPosition = ALPHABET.indexOf(ciphertext.charAt(i));
            int keyVal = (charPosition - offset) % 26;
            if (keyVal < 0)
            {
                keyVal = ALPHABET.length() + keyVal;
            }
            char replaceVal = ALPHABET.charAt(keyVal);
            plaintext += replaceVal;
        }

        return plaintext;
    }
}
