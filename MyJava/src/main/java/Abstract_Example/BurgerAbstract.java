package Abstract_Example;

/**
 * @author Test
 * An abstract class is a class that is declared abstract. This is mandatory(java doc)
 * if we have an abstract method in a class, The class must be abstract class. Because abstract method can not be present in a concrete class
 * Just because, the class is declared as abstract, we don't need to have abstract methods.
 * The class may have all abstract methods or all concrete methods or both
 * 
 * 
 * We choose abstract class
 * 1. when we know that we can implement some common behavior to the sub classes. Here we don't need to change subclasses at any cost but still
 *    we can call the implemented common behavior using its object(Subclass object)
 * 
 * 2. We can give example like, packing method of this class. Which is common across all the subclasses
 * 
 * 3. We can give, cisco's web service ie. WebResource class example
 * 
 * Finally, We go for abstract class, when we want subclasses to inherit some common behavior and at the same time, 
 * We impose some rules on the subclasses. i.e All the abstract methods must be overridden by the first concrete subclass
 *
 *
 *We can another example like, 
 *
 *Servlet is an interface with methods, init(), getServletConfig(), getServletInfo(), destroty and service()
 *
 *GenericServlet and HttpServlet are abstract classes
 *
 *The GenericServlet implements this servlet. As per the rule it must implement all the abstract methods of the Servlet.
 *
 *but GenericServlet does not implement service() method of Servlet.
 *
 *Only abstract class (which is implemented from interface/abstract class) can have this facility of not implementing all the abstract methods of a interface or abstract class
 *
 *
 *HttpServlet is also an abstract class, that too having all concrete methods.
 *
 *Actually, HttpServlet's concrete methods(doGet and doPost) do anything hardly. We always extend our custom class from HttpServlet
 *and override doGet() or doPost() to server our purpose.
 *
 *In real scenario, HttpServlet's doGet() and doPost() are never used directly. we always override them
 *
 *When a class does anything hardly, there is no point in giving a provision for creating instance of it.
 *
 *So just to prevent HttpServlet from being instantiated, it must have been declared abstract.
 *
 */
public abstract class BurgerAbstract {
	public abstract void price(); 
	public abstract void discount();
	public void packing(){
		
	}

}
