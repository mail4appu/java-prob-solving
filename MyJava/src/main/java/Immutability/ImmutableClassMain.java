package Immutability;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * @author apparao
 * 
 * Getting the duplicate list
 * 
 * List<String> cities= new ArrayList<String>();
 * List<String> citiescopy= new ArrayList<String>(cities);
 * 
 * or 
 * We can not find the clone method for list interface reference.To use clone cities should be defined as below
 * ArrayList<String> cities= new ArrayList<String>();
 * 
 * Now we can go for cloning.
 * List<String> citiesCopy=cities.clone();
 *
 */
public class ImmutableClassMain {

	public static void main(String args[]){
		try{
			ArrayList<String> cities= new ArrayList<String>();
			
			cities.add("vizag");
			cities.add("Mumbai");
			//The correct way of creating immutable collection in java
			List<String> immutableCities=Collections.unmodifiableList((ArrayList)cities.clone());
			cities.add("Hyd");
			System.out.println("Immutable Cities:  "+immutableCities);
			
			//System.out.println("Cloned Cities:  "+clonedCities);
			Map<String, String> parents= new HashMap<String, String>();
			parents.put("abc", "xyz");
			ImmutableClass imc=new ImmutableClass("appu", "varri", cities, parents);
			System.out.println(imc.getFirstName());
			imc.getCities().add("aaa");
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
