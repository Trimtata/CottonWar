package de.dataport.cottonwar.RMI;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import de.dataport.cottonwar.gui.WorldHandler;
import de.dataport.cottonwar.objekte.Einheit;

public class Service implements ServiceInterface {

	public static Service service;
	public static ServiceInterface stub; 

	public static void main(String[] argv) {
		service = new Service();
		service.start();
	}

	public static Service getService() {
		if (service == null) {
			service = new Service();
		}
		return service;
	}

	public void start() {

		try {
			Registry registry = LocateRegistry.createRegistry(1099);

			stub = (ServiceInterface) UnicastRemoteObject.exportObject(new Service(), 0);

			registry.rebind("Service", stub);

		} catch (RemoteException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public LpGoldExp getLpGoldExp() throws RemoteException {
		// System.out.println("Eine Anfrage für die Aktuellen Spielwerte wurde erstellt...");
		WorldHandler.instance.remoteGame = true;
		
		return new LpGoldExp(WorldHandler.getExp(), WorldHandler.getExp2(), WorldHandler.getGold(), WorldHandler.getGold2(),
				WorldHandler.getLp(), WorldHandler.getLp2(), Einheit.einheiten, Einheit.einheiten2, WorldHandler.evolution2, WorldHandler.evolution1);
	}

	@Override
	public void createKrieger() {
		WorldHandler.instance.createKrieger(false);
	}

	@Override
	public void createHimmelswacht() throws RemoteException {
		WorldHandler.instance.createHimmelswacht(false);
		
	}

	@Override
	public void createReiter() throws RemoteException {
		WorldHandler.instance.createReiter(false);
		
	}

	@Override
	public void createRitter() throws RemoteException {
		WorldHandler.instance.createRitter(false);
		
	}

	@Override
	public void createLord() throws RemoteException {
		WorldHandler.instance.createLord(false);
		
	}

	@Override
	public void createDrache() throws RemoteException {
		WorldHandler.instance.createDrache(false);
		
	}

}