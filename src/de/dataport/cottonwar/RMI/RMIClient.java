package de.dataport.cottonwar.RMI;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import de.dataport.cottonwar.RMI.*;

public class RMIClient {

	public static void main(String[] argv) {
		new RMIClient().start();
	}

	void start() {
		try {
			Registry registry = LocateRegistry.getRegistry("localhost", 1099);
			ServiceInterface stub = (ServiceInterface) registry.lookup("Werte übermitteln...");

				LpGoldExp s = stub.getLpGoldExp();
				System.out.println(s.toString());
			
		}
		catch (RemoteException | NotBoundException ex) {
			ex.printStackTrace();
		}
	}
}