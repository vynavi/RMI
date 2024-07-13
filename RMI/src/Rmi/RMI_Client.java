package Rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class RMI_Client {
	
	private static Scanner scan = null;

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException{
		
		try {
			Remote_Interface squaredapi= (Remote_Interface) Naming.lookup("rmi://localhost:8888/squared");
			scan = new Scanner(System.in);
			boolean flag = true;
			while (flag == true) {
				System.out.println("****************************************");
				System.out.println("The RMI App for Squared and Squared_Root");
				System.out.println("****************************************");
				System.out.println();
				System.out.println("What do you want to do?");
				System.out.println("1 - Get the Square of the Number");
				System.out.println("2 - Get the Squared Root of the Number");
				System.out.println("Any other number to stop the process.");
				int choice=getChoice();
				if (choice ==1) {
					System.out.println(squaredapi.getSquare(getInput()));
				}
				else if (choice==2) {
					System.out.println(squaredapi.getSquareRoot(getInput()));
				}
				else {
					flag = false;
					System.out.println("Ending the Process");
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static int getChoice() {
		System.out.println("Enter choice");
		int input= scan.nextInt();
		return input;
	}
	
	public static double getInput() {
		try {
			System.out.println("Enter a number:");
			double input = scan.nextDouble();
			return input;
		}catch (Exception e) {
			System.err.println("ERROR: The RMI Client is not running.....");
			return getInput();
		}
	}

}
