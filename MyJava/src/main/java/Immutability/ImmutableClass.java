package Immutability;

import java.util.Collections;
import java.util.List;
import java.util.Map;


/**
 * @author apparao
 * 
 * Immutability is associated to object state in the memory.
 * final key word is associated to reference variable in the stack not to the object in heap.
 * 
 * So when we say final int i=5;
 * the reference variable i, can not be assigned to anything.
 * i.e i=6 in the next line or some where in the program, compile throws  error.
 * 
 *  When we declare any final variable, we can not have setter method to that variable. because the setter method, gives scope to reassigning the declared variable.
 *  Hence eclipse like intelligent tools, do not show the option to generate setter method when we click generate setters/getters to a final variable
 *  or (Alt+Shift+s and r)
 *  
 *  
 *  Final  keyword to a list
 *  final List<String> cities= new ArrayList<String>();
 *  
 *  the above line says, reference variable "cities" can not be re-assigned to any other list. When we try to do so==> compile time error.
 * but you can add no of string objects in the list. The final keyword has no affect on the list behavior.
 * 
 * Then how to make immutable list/map/collection or How to make read only list/map/collection?
 * 
 * Ans: Collections.unmodifiableList(cities);  
 * 
 * 
 * So making both reference variable final and collection object as immutable is the right way of creating immutable collection.
 * 
 * final List<String> cities;
 * cities=Collections.unmodifiableList(cities); //here we should pass the already created list
 * 
 * The above does not create a new list. It just gives the list view of the existing collection. But with this reference we can not add/remove/replace the 
 * data structure elements
 *  
 *  
 *  NOTE: the assignment operator duplicates the reference, not the object. 
 *  The clone() method the duplicates the object
 *  
 *  
 * http://howtodoinjava.com/core-java/related-concepts/how-to-make-a-java-class-immutable/
 * 
 *
 */
public class ImmutableClass {
	private final String firstName;
	private String lastName;
    final private List<String> cities;
    final private Map<String, String> parents;
    
	public List<String> getCities() {
		return cities;
	}

	public Map<String, String> getParents() {
		return parents;
	}
	



	public ImmutableClass(String firstName, String lastName, List<String> cities, Map<String,String> parents){
		this.firstName = firstName;
		
		this.lastName = lastName;
		this.cities=Collections.unmodifiableList(cities);//making the list immutable
		this.parents=Collections.unmodifiableMap(parents);//making the map immutable
	}

	public String getFirstName()
	{
		return this.firstName;
	}
	public String getLastName()
	{
		return this.lastName;
	}


}
