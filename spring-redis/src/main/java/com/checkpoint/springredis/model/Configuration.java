package com.checkpoint.springredis.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class Configuration implements Serializable {

    private static final long serialVersionUID = -1165574541118110071L;
    @JsonProperty(required = true)
    @NotEmpty(message = "Can not be empty")
    private String mainMemory;
    @JsonProperty(required = true)
    @NotEmpty(message = "Can not be empty")
    private String hardDisk;
    private int    noOfNicCards;
    private int length;
    private int noOfCpus;

    public String getMainMemory() {
        return mainMemory;
    }

    public void setMainMemory(String mainMemory) {
        this.mainMemory = mainMemory;
    }

    public String getHardDisk() {
        return hardDisk;
    }

    public void setHardDisk(String hardDisk) {
        this.hardDisk = hardDisk;
    }

    public int getNoOfNicCards() {
        return noOfNicCards;
    }

    public void setNoOfNicCards(int noOfNicCards) {
        this.noOfNicCards = noOfNicCards;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getNoOfCpus() {
        return noOfCpus;
    }

    public void setNoOfCpus(int noOfCpus) {
        this.noOfCpus = noOfCpus;
    }

    @Override
    public String toString() {
        return "Configuration{" +
                "mainMemory='" + mainMemory + '\'' +
                ", hardDisk='" + hardDisk + '\'' +
                ", noOfNicCards=" + noOfNicCards +
                ", length=" + length +
                ", noOfCpus=" + noOfCpus +
                '}';
    }
}
