package com.checkpoint.springredis.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class HierarchicalCategories  implements Serializable {


    private static final long serialVersionUID = 7874254503905526340L;
    @JsonProperty("lvl0")
    private String level0;
    @JsonProperty("lvl1")
    private String level1;
    @JsonProperty("lvl2")
    private String level2;
    @JsonProperty("lvl3")
    private String level3;
    @JsonProperty("lvl4")
    private String level4;

    public String getLevel0() {
        return level0;
    }

    public void setLevel0(String level0) {
        this.level0 = level0;
    }

    public String getLevel1() {
        return level1;
    }

    public void setLevel1(String level1) {
        this.level1 = level1;
    }

    public String getLevel2() {
        return level2;
    }

    public void setLevel2(String level2) {
        this.level2 = level2;
    }

    public String getLevel3() {
        return level3;
    }

    public void setLevel3(String level3) {
        this.level3 = level3;
    }

    public String getLevel4() {
        return level4;
    }

    public void setLevel4(String level4) {
        this.level4 = level4;
    }

    @Override
    public String toString() {
        return "HierarchicalCategories{" +
                "level0='" + level0 + '\'' +
                ", level1='" + level1 + '\'' +
                ", level2='" + level2 + '\'' +
                ", level3='" + level3 + '\'' +
                ", level4='" + level4 + '\'' +
                '}';
    }
}
