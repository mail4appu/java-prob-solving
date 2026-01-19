package GenericTemplate;

public class MyClass<T extends SuperClass> {
private T  anyObject;

public T getAnyObject() {
	return anyObject;
}

public void setAnyObject(T anyObject) {
	this.anyObject = anyObject;
}

public <U> void inspect(U u){    //Generic Method that accepts any object 
    System.out.println("T: " +
    		anyObject.getClass().getName());
    System.out.println("U: " +
        u.getClass().getName());
    System.out.println("generic method has received"+u);
    
}

}

