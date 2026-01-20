package com.schneider.jersey.rest.jerseyrest.bean;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


/**
 * @author Test
 * 
 * Here the json annotations from com.fasterxml.jackson.annotation will work for both xml and json outputs
 * 
 * And the sameway, xml annotations form javax.xml.bind.annotation will work for both xml and json outputs
 * 
 * Annotation on a field has effect during the time of marshalling and unmarshalling
 * 
 * Annotation on a getter has effect during time of xml/json to object only .i.e while unmarshalling
 * 
 * Annotation on setter has effect during time of object to xml/json only i.e while marshalling
 * 
 *  //on setter will not be in output of the service
	//@XmlTransient //ignores this property in both xml and json outputs irrespective of null or emppty
 *
 *
 */
public class Stock implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotNull
	private String stockName;

	/*@DecimalMin(value = "0.0", inclusive = true)
	@DecimalMax(value = "999999999.9", inclusive = true)*/
	@DecimalMin(value = "0.0000001")
	private double stockPrice;


	private String strockCountry;
	

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public double getStockPrice() {
		return stockPrice;
	}

	
	public void setStockPrice(double stockPrice) {
		this.stockPrice = stockPrice;
	}

	
	public String getStrockCountry() {
		return strockCountry;
	}

	
	public void setStrockCountry(String strockCountry) {
		this.strockCountry = strockCountry;
	}
	
	
	

}
