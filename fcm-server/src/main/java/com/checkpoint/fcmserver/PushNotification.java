package com.checkpoint.fcmserver;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


public class PushNotification implements Serializable {
    private static final long serialVersionUID = -2848893793999405829L;
    private String title;
    private String text;
    Map<String, String> data = new HashMap<>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Map<String, String> getData() {
        return data;
    }

    public void setData(Map<String, String> data) {
        this.data = data;
    }
}
