package de.dataport.cottonwar.RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServiceInterface extends Remote {

	LpGoldExp getLpGoldExp() throws RemoteException;

	
	

}