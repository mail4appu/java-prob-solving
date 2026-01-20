package com.checkpoint.fcmserver;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class FCMToken implements Serializable {

    private static final long serialVersionUID = -4661917613034833925L;
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
