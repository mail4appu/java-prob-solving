package com.example.demo;

public class DemoThreadLocal {

    public static final ThreadLocal<DemoUser> userThreadLocal= new ThreadLocal<>();

    public static void setContext(DemoUser context){
        userThreadLocal.set(context);

    }

    public static void unsetContect(){
        userThreadLocal.remove();
    }

    public static DemoUser getContext(){
        return userThreadLocal.get();
    }

}
