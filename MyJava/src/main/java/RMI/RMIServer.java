package RMI;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

/**
 * @author vapparao
 * 
 * NOTE: when you bind  the object to RMI registry, the rmi registry downloads the class file of the object that is to be 
 * registered
 *  how to rmiregistry knows where it shuld download the class file  from?
 *  Ans: set the following property in the configurations on eclipse
 *  -Djava.rmi.server.codebase= file:///C:\Users\vapparao\workspace\SampleProject\bin/
 * 
 *
 */
public class RMIServer {
public static void main(String[] args) {
	try {
		//here only we can create rmi registry instance by LocateRegistry.createRegistry(1099) without using any configuratioins
		//it will create an instance of rmi registry
		//this line registers the RMIImpl in the rmi registry
		Naming.rebind("rmiObject", new RMIImpl());
		System.out.println("bound object successfully");
	} catch (RemoteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	
}
