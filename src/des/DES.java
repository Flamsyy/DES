package des;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class DES
{
	public static String encrypt(String plainText, String mode, String padding, String key)
	{
		return "I work";
	}
	
	public static String decrypt(String cipherText, String mode, String padding, String key)
	{
		return null;
	}
}

/*
Scanner sc = new Scanner(System.in);

System.out.println("Plaintext: ");
String plaintext = sc.next();

try {
    KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
    SecretKey key = keyGenerator.generateKey();

    Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
    cipher.init(Cipher.ENCRYPT_MODE, key);

    System.out.println("Ciphertext: " + new String(cipher.doFinal(plaintext.getBytes())));
} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException |
        IllegalBlockSizeException | BadPaddingException e) {
    e.printStackTrace();
}
*/