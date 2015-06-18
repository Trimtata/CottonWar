package de.dataport.cottonwar.RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServiceInterface extends Remote {

	LpGoldExp getLpGoldExp() throws RemoteException;

	void createKrieger() throws RemoteException;

	void createHimmelswacht()throws RemoteException;

	void createReiter()throws RemoteException;

	void createRitter()throws RemoteException;

	void createLord()throws RemoteException;

	void createDrache()throws RemoteException;

	void createEvolution()throws RemoteException;
	

}