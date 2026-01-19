package Encryption;

import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AES_Encryption
{
    static String plainText = "This is a plain text which need to be encrypted by AES Algorithm with CBC Mode";
    static String secretKey="Select and ConfiSelect and Confi";

    public static void main(String[] args) throws Exception
    {
        String keyStr= Base64.getEncoder().encodeToString(secretKey.getBytes());
        byte[] decodedKey = Base64.getDecoder().decode(keyStr);
        System.out.println("Decoded Key: "+decodedKey);
       // KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        //keyGenerator.init(128);

        // Generate Key
        SecretKey key = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");

        // Generating IV.
        byte[] IV = new byte[16];
        SecureRandom random = new SecureRandom();
        random.nextBytes(IV);

        System.out.println("Original Text  : "+plainText);

        byte[] cipherText = encrypt(plainText.getBytes(),key, IV);
        System.out.println("Encrypted Text : "+Base64.getEncoder().encodeToString(cipherText) );

        String decryptedText = decrypt(cipherText,key, IV);
        System.out.println("DeCrypted Text : "+decryptedText);

    }

    public static byte[] encrypt (byte[] plaintext,SecretKey key,byte[] IV ) throws Exception
    {
        long start=System.currentTimeMillis();
        //Get Cipher Instance
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

        //Create SecretKeySpec
        SecretKeySpec keySpec = new SecretKeySpec(key.getEncoded(), "AES");

        //Create IvParameterSpec
        IvParameterSpec ivSpec = new IvParameterSpec(IV);

        //Initialize Cipher for ENCRYPT_MODE
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);

        //Perform Encryption
        byte[] cipherText = cipher.doFinal(plaintext);
        System.out.println("Time taken for encryption: "+(System.currentTimeMillis()-start));
        return cipherText;
    }

    public static String decrypt (byte[] cipherText, SecretKey key,byte[] IV) throws Exception
    {
        //Get Cipher Instance
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

        //Create SecretKeySpec
        SecretKeySpec keySpec = new SecretKeySpec(key.getEncoded(), "AES");

        //Create IvParameterSpec
        IvParameterSpec ivSpec = new IvParameterSpec(IV);

        //Initialize Cipher for DECRYPT_MODE
        cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);

        //Perform Decryption
        byte[] decryptedText = cipher.doFinal(cipherText);

        return new String(decryptedText);
    }
}
