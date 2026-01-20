package com.checkpoint.springredis.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EpcState implements Serializable {
    private static final long serialVersionUID = 6440337661927648716L;

    @Id
    @JsonProperty("_id")
    private String objectId;
    private String businessLocation;
    private String epc;
    private long firstProcessID;
    private long firstSeenTime;
    private long insertDate;
    private long lastSeenProcessID;
    private long lastSeenTime;
    private String readLocation;
    private String sku;
    private String state;
    private long updateDate;


    // Getter Methods

    public String getObjectId() {
        return objectId;
    }

    public String getBusinessLocation() {
        return businessLocation;
    }

    public String getEpc() {
        return epc;
    }

    public long getFirstProcessID() {
        return firstProcessID;
    }

    public long getFirstSeenTime() {
        return firstSeenTime;
    }

    public long getInsertDate() {
        return insertDate;
    }

    public long getLastSeenProcessID() {
        return lastSeenProcessID;
    }

    public long getLastSeenTime() {
        return lastSeenTime;
    }

    public String getReadLocation() {
        return readLocation;
    }

    public String getSku() {
        return sku;
    }

    public String getState() {
        return state;
    }

    public long getUpdateDate() {
        return updateDate;
    }

    // Setter Methods

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public void setBusinessLocation(String businessLocation) {
        this.businessLocation = businessLocation;
    }

    public void setEpc(String epc) {
        this.epc = epc;
    }

    public void setFirstProcessID(long firstProcessID) {
        this.firstProcessID = firstProcessID;
    }

    public void setFirstSeenTime(long firstSeenTime) {
        this.firstSeenTime = firstSeenTime;
    }

    public void setInsertDate(long insertDate) {
        this.insertDate = insertDate;
    }

    public void setLastSeenProcessID(long lastSeenProcessID) {
        this.lastSeenProcessID = lastSeenProcessID;
    }

    public void setLastSeenTime(long lastSeenTime) {
        this.lastSeenTime = lastSeenTime;
    }

    public void setReadLocation(String readLocation) {
        this.readLocation = readLocation;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setUpdateDate(long updateDate) {
        this.updateDate = updateDate;
    }


    @Override
    public String toString() {
        return "EpcState{" +
                "objectId='" + objectId + '\'' +
                ", businessLocation='" + businessLocation + '\'' +
                ", epc='" + epc + '\'' +
                ", firstProcessID=" + firstProcessID +
                ", firstSeenTime=" + firstSeenTime +
                ", insertDate=" + insertDate +
                ", lastSeenProcessID=" + lastSeenProcessID +
                ", lastSeenTime=" + lastSeenTime +
                ", readLocation='" + readLocation + '\'' +
                ", sku='" + sku + '\'' +
                ", state='" + state + '\'' +
                ", updateDate=" + updateDate +
                '}';
    }
}
