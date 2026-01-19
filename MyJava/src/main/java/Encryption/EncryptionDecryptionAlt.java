package Encryption;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

public class EncryptionDecryptionAlt {

    public static void main(String[] args)
    {
        long start=System.currentTimeMillis();
        final String secretKey = "ssshhhhhhhhhhh!!!!";

        String originalString = "Vizag is my favorite placejkdslaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaalkljdsaafffffffffffffffffffffffffff";
        String encryptedString = encrypt(originalString, secretKey) ;
        String decryptedString = decrypt(encryptedString, secretKey) ;

        System.out.println(originalString);
        System.out.println(encryptedString);
        System.out.println(decryptedString);
        System.out.println("Time taken for whole: "+(System.currentTimeMillis()-start));
    }

    private static SecretKeySpec secretKey;
    private static byte[] key;

    public static void setKey(String myKey)
    {
        MessageDigest sha = null;
        try {
            long start=System.currentTimeMillis();
            key = myKey.getBytes("UTF-8");
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            secretKey = new SecretKeySpec(key, "AES");
            System.out.println("Time taken for setting key:"+(System.currentTimeMillis()-start));
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public static String encrypt(String strToEncrypt, String secret)
    {
        try
        {
            long start=System.currentTimeMillis();
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            String s = Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes()));
            System.out.println("Time taken for encryption: "+(System.currentTimeMillis()-start));
            return s;
        }
        catch (Exception e)
        {
            System.out.println("Error while encrypting: " + e.toString());
        }
        return null;
    }

    public static String decrypt(String strToDecrypt, String secret)
    {
        try
        {
            long start=System.currentTimeMillis();
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            String s = new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
            System.out.println("Time taken for decryption: "+(System.currentTimeMillis()-start));
            return s;
        }
        catch (Exception e)
        {
            System.out.println("Error while decrypting: " + e.toString());
        }
        return null;
    }
}
