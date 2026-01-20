package com.maxenglander.examples.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;


/**
 *
 * @author maxenglander
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class TrackV2 extends TrackV1 {
    private final int lengthInSeconds;

    TrackV2(){
    	this("", "", 0, 0);
    	
    }
    
    public TrackV2(String artistName, String title, int length, int year) {        
        super(artistName, title, (length / 60) + ":" + (length % 60), year);
        this.lengthInSeconds = length;
    }
    
    @Override
    @JsonProperty("artist")
    @XmlElement(name = "artist")
    public String getArtistName() {
        return super.getArtistName();
    }
    
    @Override
    public Object getLength() {
        return lengthInSeconds;
    }
            
    @Override
    @JsonIgnore
    @XmlTransient
    public int getYear() {
        return super.getYear();
    }
}
