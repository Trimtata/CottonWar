package de.dataport.cottonwar.objekte;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import de.dataport.cottonwar.gui.GameObject;

public class Spielfeld extends JPanel {

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		List<Einheit> einheiten = new ArrayList<Einheit>();
		einheiten.addAll(Einheit.einheiten);
		einheiten.addAll(Einheit.einheiten2);

		for (Einheit e : einheiten) {
			GameObject a = new GameObject();
			g.drawImage(a.getImage(), e.x, e.y, 128, 128, null);
		}
	}

}

/* Range mit Parameter(Bogenmeister), , Basen, nach Kampf fortbewegen
 * Speichern können, Multiplayer, Hauptmenü, Bilder */
