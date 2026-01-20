package com.checkpoint.swaggerdemo.model;

import com.checkpoint.swaggerdemo.constants.ProductConstants;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Objects;

@Document(collection = "products")
@ApiModel
public class Product {

    @Id
    private String id;

    @NotEmpty(message = "Can not be empty")
    @Length(max = ProductConstants.MAX_STRING_SIZE_LONG)
    @JsonProperty(required = true)
    @ApiModelProperty(required = true, example = "Name of the proudct")
    private String name;
    @ApiModelProperty(value = "Description of the product", example = "Windows laptop")
    private String description;
    @ApiModelProperty(required = true)
    @JsonProperty(required = true)
    @NotEmpty(message = "Not a valid price.")
    @Pattern(regexp = ProductConstants.PRICE_REGEX, message = "Only numeric values are accepted in the price field")
    private String price;
    @JsonProperty(required = true)
    @NotEmpty(message = "Invalid laptop type")
    @Pattern(regexp = "^(low-end|medium-end|high-end)$", message = "Laptop type can be only be 'low-end' or 'medium-end' or 'high-end'")
    private String type;
    @JsonProperty(required = true)
    @NotEmpty(message = "Can not be empty")
    @Pattern(regexp = "^(windows|linux|ios)$", message = " Operating system could be only 'windows' or 'linux' or 'ios'")
    private String os;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name) &&
                Objects.equals(price, product.price) &&
                Objects.equals(type, product.type) &&
                Objects.equals(os, product.os);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, type, os);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price='" + price + '\'' +
                ", type='" + type + '\'' +
                ", os='" + os + '\'' +
                '}';
    }
}
