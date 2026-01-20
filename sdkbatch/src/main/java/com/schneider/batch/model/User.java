package com.schneider.batch.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.stereotype.Repository;

/**
 * Created by SESA439295 on 7/4/2017.
 */
@Repository
public class User {
    String fedIdKey;
    String fedIDValue;

    public String getFedIdKey() {
        return fedIdKey;
    }

    public void setFedIdKey(String fedIdKey) {
        this.fedIdKey = fedIdKey;
    }

    public String getFedIDValue() {
        return fedIDValue;
    }

    public void setFedIDValue(String fedIDValue) {
        this.fedIDValue = fedIDValue;
    }
    @Override
    public String toString(){
       return  ToStringBuilder.reflectionToString(this);
    }
}
