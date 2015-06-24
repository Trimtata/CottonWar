package de.dataport.cottonwar.gui;

import java.awt.Graphics;

import javax.swing.JPanel;
import de.dataport.cottonwar.objekte.Spielfeld;

public class World extends JPanel {

	private static final long serialVersionUID = 1L;

	public World() {
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(Spielfeld.backgroundw, 0, 0, 1200, 700, null);
	}
}
