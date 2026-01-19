package Schneider_domain_decoding;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class Decoding {
    public static void main(String[] args) {
        String actual="+";
        String urlEncoded="OYpDsgHN3VCJGhtsFIHBl0RRXlF%2F%2BOEeQFzpof7ZRjw%3D";
        try {
            String secEncoded = URLEncoder.encode(actual, StandardCharsets.UTF_8.name());
            System.out.println(secEncoded);
            String s1 = URLEncoder.encode(secEncoded, StandardCharsets.UTF_8.name());
            System.out.println(s1);
            String firstDecoded = URLDecoder.decode(s1, StandardCharsets.UTF_8.name());
            System.out.println(firstDecoded);
            String secDecoded = URLDecoder.decode(firstDecoded, StandardCharsets.UTF_8.name());
            System.out.println(secDecoded);
            String thirdDecoded=URLDecoder.decode(secDecoded, StandardCharsets.UTF_8.name());
            System.out.println(thirdDecoded);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }
}
