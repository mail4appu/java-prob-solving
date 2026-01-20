package com.lookout.rediscachedemo;

import lombok.Data;

import java.io.Serializable;
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 7156526077883281623L;
    private String id;
    private String name;
    private long followers;

    private Address address;


}
