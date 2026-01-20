package com.checkpoint.springredis.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;
import java.util.List;

@RedisHash
public class Product implements Serializable {

    private static final long serialVersionUID = -3509679988765141168L;

    @Id
    @JsonProperty("objectID")
    private long objectId;

    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;
    @JsonProperty("categories")
    @JsonFormat(shape = JsonFormat.Shape.ARRAY)
    private List<String> categories;
    @JsonProperty("hierarchicalCategories")
    private HierarchicalCategories hierarchicalCategories;
    @JsonProperty("type")
    private String type;
    @JsonProperty("price")
    private String price;
    @JsonProperty("brand")
    private String brand;
    @Indexed
    @JsonProperty("price_range")
    private String priceRange;
    @JsonProperty("image")
    private String image;
    @JsonProperty("url")
    private String url;
    @JsonProperty("free_shipping")
    private boolean freeShipping;
    @JsonProperty("popularity")
    private Long popularity;
    @JsonProperty("rating")
    private Integer rating;

    public long getObjectId() {
        return objectId;
    }

    public void setObjectId(long objectId) {
        this.objectId = objectId;
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

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public HierarchicalCategories getHierarchicalCategories() {
        return hierarchicalCategories;
    }

    public void setHierarchicalCategories(HierarchicalCategories hierarchicalCategories) {
        this.hierarchicalCategories = hierarchicalCategories;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(String priceRange) {
        this.priceRange = priceRange;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isFreeShipping() {
        return freeShipping;
    }

    public void setFreeShipping(boolean freeShipping) {
        this.freeShipping = freeShipping;
    }

    public Long getPopularity() {
        return popularity;
    }

    public void setPopularity(Long popularity) {
        this.popularity = popularity;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Product{" +
                "objectId=" + objectId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", categories=" + categories +
                ", hierarchicalCategories=" + hierarchicalCategories +
                ", type='" + type + '\'' +
                ", price='" + price + '\'' +
                ", brand='" + brand + '\'' +
                ", priceRange='" + priceRange + '\'' +
                ", image='" + image + '\'' +
                ", url='" + url + '\'' +
                ", freeShipping=" + freeShipping +
                ", popularity=" + popularity +
                ", rating=" + rating +
                '}';
    }
}
