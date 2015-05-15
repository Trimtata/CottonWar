package de.dataport.cottonwar.game;

import java.awt.EventQueue;

import de.dataport.cottonwar.gui.World;

public class Main {

	public static void main(String[] args) {
		//---------------------------
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					World window = new World();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		//-------------------------

	}

}
