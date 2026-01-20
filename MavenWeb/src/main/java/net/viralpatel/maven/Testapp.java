package net.viralpatel.maven;

import javax.ws.rs.core.UriBuilder;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by SESA439295 on 4/4/2017.
 * UriBuilder, UriInfo are the means of getting query string from a Https request
 */
public class Testapp {
    static  int a=1;
    public static void main(String[] args) {
        // String redirecUrl="https://abc.def.com/def/ghi?user=MARIE-HÉLÈNE&password=appu?def=def";
        // String redirecUrl="https://localhost:8080/def?user='appu$'#abcd";
        List<String> strings= new ArrayList<String>();
        strings.add("appu");
        strings.add("Pori");
        strings.add("def");
        strings.add("mnpq");

        strings.add("dabbba");
        strings.add("xyz");
        strings.add("daksajf");
        int size = strings.size();
        int limit=100;
        for(int i = 0; i< size; i+=limit){
            List<String> strings1 = strings.subList(i, Math.min(size, i+limit));
            System.out.println(strings1);
        }


    }


    private static String test() throws Exception {

        System.out.println("*************: "+a);
        try {
            URI uri = null;


            String url = "[abc";

            System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

            String pattern="^[a-zA-Z0-9]+[a-zA-Z0-9_-]+";

            if("abc".matches(pattern)){
                System.out.println("success");
            }


            try {
                uri = new URI(url);
                if(!uri.isOpaque()) {
                    System.out.println("valid uri");
                }
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            //Fetch query string from redirect end point
            System.out.println(uri.getFragment());
            UriBuilder uriBuilder = UriBuilder.fromUri(uri);
            System.out.println(uriBuilder.build().getFragment());
            String queryString = uri.getQuery();
            String encodedQueryString = "";
            if (queryString != null) {
                encodedQueryString = URLEncoder.encode(queryString, "UTF-8");
             //   System.out.println("*********: " + redirecUrl.replace(queryString, encodedQueryString));
            }

        } finally {
            return "in finally";
        }


    }
}
