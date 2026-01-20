package com.idrive;

import com.google.common.util.concurrent.RateLimiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import javax.ws.rs.core.Response;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class App {
    RestTemplate template = new RestTemplate();
    public static void main(String[] args) {
       String s="abcd";
        final String s1 = s.split("@")[0];
        System.out.println(s1);
    }


}
