package de.dataport.cottonwar.RMI;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import de.dataport.cottonwar.RMI.*;
import de.dataport.cottonwar.gui.WorldHandler;

public class RMIClient {

	public static RMIClient client;
	public static ServiceInterface stub; 

	public static void main(String[] argv) {
		client = new RMIClient();
		client.start();
	}

	public void start() {

		try {

			Registry registry = LocateRegistry.getRegistry("169.254.177.225", 1099);
			
			stub = (ServiceInterface) registry.lookup("Service");

			LpGoldExp s = stub.getLpGoldExp();
			WorldHandler.instance.setWerte(s);
			WorldHandler.instance.remoteGame = true;

		} catch (RemoteException | NotBoundException ex) {
			ex.printStackTrace();
		}

	}

	public static RMIClient getRMIClient() {
		if (client == null) {
			client = new RMIClient();
		}
		return client;
	}

}
