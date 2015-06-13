package de.dataport.cottonwar.RMI;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import de.dataport.cottonwar.gui.WorldHandler;
import de.dataport.cottonwar.RMI.*;

public class Service implements ServiceInterface {

	private static List<LpGoldExp> werte;

	Service() throws RemoteException {
		super();
	}

	public static void main(String[] argv) {

		werte = new ArrayList<LpGoldExp>();
		werte.add(new LpGoldExp(WorldHandler.exp, WorldHandler.exp2, WorldHandler.gold, WorldHandler.gold2, WorldHandler.lp, WorldHandler.lp2));

		try {
			Registry registry = LocateRegistry.createRegistry(1099);

			ServiceInterface stub = (ServiceInterface) UnicastRemoteObject.exportObject(new Service(), 0);

			registry.rebind("Service", stub);

		}
		catch (RemoteException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public LpGoldExp getLpGoldExp() throws RemoteException {
		System.out.println("Eine Anfrage für die Aktuellen Spielwerte wurde erstellt...");
		return werte.get(0);
	}		


}