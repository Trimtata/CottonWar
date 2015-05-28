package de.dataport.cottonwar.gui;

import javax.swing.JFrame;

public class WorldHandler extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8853228346248816103L;
public WorldHandler(){
	this.setSize(800,600);
	World w = new World();
	this.add(w);
	this.setVisible(true);
}
}
