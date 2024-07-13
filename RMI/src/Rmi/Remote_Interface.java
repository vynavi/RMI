package Rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Remote_Interface extends Remote {
	public double getSquare(double input) throws RemoteException;
	public double getSquareRoot(double input) throws RemoteException;
	
}
