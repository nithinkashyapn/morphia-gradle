package in.nithin.model;

import org.bson.types.ObjectId;
import org.glassfish.jersey.linking.InjectLink;
import org.glassfish.jersey.linking.InjectLinks;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;

@Entity("caesar")
public class Caesar {

    // Character map
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    public String message;
    public int offset;

    public Caesar(){}

    public Caesar(String message, int offset) {
        this.message = message;
        this.offset = offset;
    }

    // Constructor
    public Caesar(Caesar caesar){
        this.message = caesar.message;
        this.offset = caesar.offset;
    }

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
