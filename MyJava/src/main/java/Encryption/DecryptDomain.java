package Encryption;


import org.apache.commons.lang3.StringUtils;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DecryptDomain {
    public static void main(String[] args) {
        String s="S1----447708561----GCR_NT_CB----KB_GCR_NT_CB----171003.0--------EN%7CJSESSIONID%3DCA19VYFUIx_xtHXnAx3TJYWz5kzLZwHWofMR_SAPteAqoZ_V8UfrH3Y3BK_2fttl%3Bversion%3D1%3Bpath%3D%2F%3Bdomain%3DbLeeGChwJfUsHO2Tg1bqnD%2FQv1ECvcN9Ql57w4DLQpBNCtch4cB8nQvvYxPbSMtZ%7Csaplb_*%3D%28J2EE301179320%29301179350%3Bversion%3D1%3Bpath%3D%2F%3Bdomain%3DbLeeGChwJfUsHO2Tg1bqnD%2FQv1ECvcN9Ql57w4DLQpBNCtch4cB8nQvvYxPbSMtZ";
        StringBuilder sb= new StringBuilder(s);
        String[] domains = s.split("domain");
        System.out.println(domains.length);
        System.out.println(Arrays.toString(domains));

        String s1 = StringUtils.substringBetween(domains[1], "%3D","%7C");
        System.out.println(s1);
        s.replaceAll(s1, decryptF(s1.getBytes()));

        //String s2 = decryptF();
        //System.out.println(s2);

        //List<Object> paraGraphTokens = getParaGraphTokens(domains[1]);
        System.out.println(domains[1]);
        Pattern pattern = Pattern.compile("%3D(.*?)%7C");
        Matcher matcher = pattern.matcher(domains[1]);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
        /*for(Object token:paraGraphTokens){
            System.out.println(token.toString());
        }*/

    }

    public static List<Object> getParaGraphTokens(String paragraphText) {
        System.out.println("preparing paragraph tokens");
        List<Object> paraGraphTokens = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(paragraphText);
        while (st.hasMoreTokens()) {
            paraGraphTokens.add(st.nextToken("'%3D''%7C' "));
        }
        return paraGraphTokens;
    }


    private static String decryptF(byte[] encryptionBytes) {
        Cipher c = null;
        try {
            c = Cipher.getInstance("AES");

            long start = System.currentTimeMillis();
            System.out.println("========duriong decryption=====\n");


            byte[] keyBytes = Arrays.copyOf("SelectAndConfig".getBytes(), 16);
            c.init(Cipher.DECRYPT_MODE, new SecretKeySpec(keyBytes, "AES"));

            byte[] decrypt = c.doFinal(encryptionBytes);

            String decrypted = new String(decrypt);
            System.out.println("Time taken for decryption: " + (System.currentTimeMillis() - start));

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
        }
        return null;
    }
}
