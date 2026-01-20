package com.checkpoint.springredis.model;

import com.checkpoint.springredis.constant.ApplicationConstants;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Objects;

public class Computer implements  Serializable{


    /*private static final long serialVersionUID = 5963862224671927910L;*/
    @Id
    private String id;


    @NotEmpty(message = "Can not be empty")
    @Length(max = ApplicationConstants.MAX_STRING_SIZE_LONG)
    @JsonProperty(required = true)
    private String name;
    private String description;
    @JsonProperty(required = true)
    @NotEmpty(message = "Not a valid price.")
    @Pattern(regexp = ApplicationConstants.PRICE_REGEX, message = "Only numeric values are accepted in the price field")
    private String price;
    @JsonProperty(required = true)
    @NotEmpty(message = "Invalid laptop type")
    @Pattern(regexp = "^(low-end|medium-end|high-end)$", message = "Laptop type can be only be 'low-end' or 'medium-end' or 'high-end'")
    private String type;
    @JsonProperty(required = true)
    @NotEmpty(message = "Can not be empty")
    @Pattern(regexp = "^(windows|linux|ios)$", message = " Operating system could be only 'windows' or 'linux' or 'ios'")
    private String os;

    @Valid
    @NotNull
    private Configuration configuration;

    @NotNull
    private String manufacturer;

    private String deliveryCity;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }


    public Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Computer computer = (Computer) o;
        return Objects.equals(name, computer.name) &&
                Objects.equals(price, computer.price) &&
                Objects.equals(type, computer.type) &&
                Objects.equals(os, computer.os);
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getDeliveryCity() {
        return deliveryCity;
    }

    public void setDeliveryCity(String deliveryCity) {
        this.deliveryCity = deliveryCity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, type, os);
    }

    @Override
    public String toString() {
        return "Computer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price='" + price + '\'' +
                ", type='" + type + '\'' +
                ", os='" + os + '\'' +
                '}';
    }
}
