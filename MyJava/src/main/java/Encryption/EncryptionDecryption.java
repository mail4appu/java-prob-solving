package Encryption;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;


public class EncryptionDecryption {
    static String algorithm = "AES";
    static String toBeEncrypted="conf.schneider-electric.com";
    static String originalString = "S1----1744466412----GCR_MTZ3_CB----KB_GCR_MTZ3_CB----181030.0--------EN%7CJSESSIONID%3DTMdiEuCYKWqesaAUqkM49pI_E1XLZwFCBAUe_SAPhrMp7QkdJo8kqziJcH_L7ruo%3Bversion%3D1%3Bpath%3D%2F%3Bdomain%3Dconf.schneider-electric.com%7CROUTEID%3D9925E754E8CA24555D3CC1098E201B720695BB64F4BC1B4AFF6589A19C941655825B885DA4C9874A097AE20BDA7A7075B67B2D9D3BD9657BC174A87AC8AE2D82E80AD3B8D6B8D0C364F4871FC0856192244AF3B4%3Bversion%3D1%3Bpath%3D%2F%3Bdomain%3Dconf.schneider-electric.com%7Csaplb_*%3D%28J2EE503645220%29503645250%3Bversion%3D1%3Bpath%3D%2F%3Bdomain%3Dconf.schneider-electric.com";
    static String secretKey = "Select and Config";

    public static void main(String[] args) throws Exception {
        //This statement makes lot of difference in time taken
        KeyGenerator.getInstance(algorithm).generateKey();

        //printing the symmetric key
        System.out.println("========duriong encryption=====\n");
       //System.out.println("key:  " + Base64.encodeBase64String(symKey.getEncoded()).toString());

        System.out.println("text to be encrypted: " + toBeEncrypted);
        String encryptedString = encryptF(toBeEncrypted);
        originalString=originalString.replaceAll(toBeEncrypted, encryptedString);
        String[] domains = originalString.split("domain");
        System.out.println(domains.length);
        System.out.println(Arrays.toString(domains));
        String s1 = StringUtils.substringBetween(domains[1], "%3D","%7C");
        System.out.println(s1);
        originalString=originalString.replaceAll(s1, decryptF(s1));
        System.out.println(originalString);


    }

    private static String encryptF(String input) {
        long start = System.currentTimeMillis();
        Cipher c = null;
        try {
            c = Cipher.getInstance(algorithm);

            byte[] keyBytes = Arrays.copyOf(secretKey.getBytes("UTF-8"), 16);
            c.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(keyBytes, "AES"));
            byte[] inputBytes = input.getBytes();
            byte[] bytes = c.doFinal(inputBytes);
            System.out.println("Encrypted Text:  " + Base64.encodeBase64String(bytes).toString());
            System.out.println("Time taken for encryption: " + (System.currentTimeMillis() - start));
            return Base64.encodeBase64String(bytes);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String decryptF(String encryptedStr) {
        Cipher c = null;
        try {
            c = Cipher.getInstance(algorithm);

            long start = System.currentTimeMillis();
            System.out.println("========duriong decryption=====\n");


            byte[] keyBytes = Arrays.copyOf(secretKey.getBytes("UTF-8"), 16);
            c.init(Cipher.DECRYPT_MODE, new SecretKeySpec(keyBytes, "AES"));

            byte[] decrypt = c.doFinal(Base64.decodeBase64(encryptedStr));

            String decrypted = new String(decrypt);
            System.out.println("Time taken for decryption: " + (System.currentTimeMillis() - start));
            System.out.println("Decrypted String: "+decrypted);

            return decrypted;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
