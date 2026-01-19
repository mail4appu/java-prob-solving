package RMI;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIClient {
public static void main(String[] args) {
	try {
		Registry myRegistry = LocateRegistry.getRegistry(1099);
		RMIInterface impl=(RMIInterface)myRegistry.lookup("rmiObject");
		System.out.println(" ip addresss is :   "+impl.showIPAddress());
	} catch (RemoteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    catch(Exception ex){
    	ex.printStackTrace();
    }
}
}
