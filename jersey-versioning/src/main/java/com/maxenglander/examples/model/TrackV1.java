package com.maxenglander.examples.model;

import java.lang.reflect.Constructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author maxenglander
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class TrackV1 {
    private final String artistName;
    private final String length;
    private final String title;
    private final int year;
    
    
    TrackV1(){
    	this("abc", "def", "xyZ", 0);
    	
    }
   

	public TrackV1(String artistName, String title, String length, int year) {
        this.artistName = artistName;
        this.length = length;
        this.title = title;
        this.year = year;
    }    
    
	
    public String getArtistName() {
        return this.artistName;
    }
    
    public Object getLength() {
        return length;
    }
    
    public String getTitle() {
        return this.title;
    }
    
    public int getYear() {
        return year;
    }
}
