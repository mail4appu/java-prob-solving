package com.checkpoint.springredis.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bson.Document;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

public class EpcCCStagingItem implements Serializable {


    private static final long serialVersionUID = -8314329813283388594L;
    @Id
    @JsonProperty("_id")
    @JsonAlias({"_id","objectId"})
    private String objectId;
    private String epc;
    @JsonProperty("ccDetailID")
    @JsonAlias({"ccDetailID","ccDetailId" })
    private String ccDetailId;
    private String isExpected;
    private String productIdentifier;
    private String tradeItem;
    private long countTS;

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getEpc() {
        return epc;
    }

    public void setEpc(String epc) {
        this.epc = epc;
    }

    public String getCcDetailId() {
        return ccDetailId;
    }

    public void setCcDetailId(String ccDetailId) {
        this.ccDetailId = ccDetailId;
    }

    public String getIsExpected() {
        return isExpected;
    }

    public void setIsExpected(String isExpected) {
        this.isExpected = isExpected;
    }

    public String getProductIdentifier() {
        return productIdentifier;
    }

    public void setProductIdentifier(String productIdentifier) {
        this.productIdentifier = productIdentifier;
    }

    public String getTradeItem() {
        return tradeItem;
    }

    public void setTradeItem(String tradeItem) {
        this.tradeItem = tradeItem;
    }

    public long getCountTS() {
        return countTS;
    }

    public void setCountTS(long countTS) {
        this.countTS = countTS;
    }

    @Override
    public String toString() {
        return "EpcCCStagingItem{" +
                "objectId='" + objectId + '\'' +
                ", epc='" + epc + '\'' +
                ", ccDetailId='" + ccDetailId + '\'' +
                ", isExpected='" + isExpected + '\'' +
                ", productIdentifier='" + productIdentifier + '\'' +
                ", tradeItem='" + tradeItem + '\'' +
                ", countTS=" + countTS +
                '}';
    }
}
