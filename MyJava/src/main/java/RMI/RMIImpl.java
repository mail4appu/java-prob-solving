package RMI;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RMIImpl extends UnicastRemoteObject implements RMIInterface{
	
	protected RMIImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String showIPAddress() throws RemoteException{
		String ip=null;
		try {
			ip = InetAddress.getLocalHost().getHostName();
			System.out.println(" name in the impl class"+ip);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return ip;
	}

}
