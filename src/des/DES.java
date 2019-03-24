package des;

import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Scanner;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class DES
{
	public static String encrypt(String plainText, String mode, String padding, String key) throws IllegalBlockSizeException, BadPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, NoSuchAlgorithmException, NoSuchPaddingException
	{
		SecretKey secretKey = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "DES");
		Cipher cipher = Cipher.getInstance("DES/"+mode+"/"+padding);
		if(mode.equals("ECB")) 
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		else
		cipher.init(Cipher.ENCRYPT_MODE, secretKey, new IvParameterSpec(new byte[16]));

		if(padding.equals("NoPadding") && plainText.getBytes().length % 16 != 0)
		{
		System.out.println("wrong block size");
		return "";
		}
		byte[] cipherbytes = cipher.doFinal(plainText.getBytes());
		return Base64.getEncoder().encodeToString(cipherbytes);

	}
	
	public static String decrypt(String cipherText, String mode, String padding, String key)
	{
		SecretKey secretKey = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "DES");
		Cipher cipher = Cipher.getInstance("DES/"+mode+"/"+padding);
		if(mode.equals("ECB"))
		cipher.init(Cipher.DECRYPT_MODE, secretKey);
		else
		cipher.init(Cipher.DECRYPT_MODE, secretKey, new IvParameterSpec(new byte[16]));
		byte[] cipherbytes = cipher.doFinal(Base64.getDecoder().decode(cipherText));
	
	return new String(cipherbytes);
	}
}

