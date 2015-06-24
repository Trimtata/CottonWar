package de.dataport.cottonwar.gui;

import java.awt.Graphics;

import javax.swing.JPanel;

import de.dataport.cottonwar.objekte.Spielfeld;

public class Haupthint extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(Spielfeld.backgroundh, 0, 0, 400, 600,null);
	}
}
