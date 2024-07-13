package Rmi;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;

public class RMI_Server extends UnicastRemoteObject implements Remote_Interface {

	public RMI_Server() throws RemoteException {
	}
	
	@Override
	public double getSquare(double input) throws RemoteException {
		return input*input;
	}

	@Override
	public double getSquareRoot(double input) throws RemoteException {
		return Math.sqrt(input);
	}

	public static void main(String[] args) throws RemoteException, AlreadyBoundException {
		try {
			Registry registry = LocateRegistry.createRegistry(8888);
			registry.bind("squared", new RMI_Server());
			System.out.println("The RMI Server is running and ready.....");
		} catch(Exception e) {
			System.out.println("ERROR: The RMI Server is not running.....");
		}
	}

}
