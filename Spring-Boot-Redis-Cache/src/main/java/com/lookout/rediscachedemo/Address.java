package com.lookout.rediscachedemo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Address implements Serializable {
private String streetName;
private String pinCode;
private String cityName;

}
