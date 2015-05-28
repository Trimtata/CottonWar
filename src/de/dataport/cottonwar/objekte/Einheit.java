package de.dataport.cottonwar.objekte;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import de.dataport.cottonwar.datastructures.Gameobject;
import de.dataport.cottonwar.gui.GameObject;

public class Einheit {

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	String name;
	int lp, ap, spd, range, gold, ep, cost, id, x, y, height, width;

	public Einheit(String name, int lp, int ap, int spd, int range, int gold, int ep, int cost, int id, int x, int y, int height, int width) {
		super();
		this.name = name;
		this.lp = lp;
		this.ap = ap;
		this.spd = spd;
		this.range = range;
		this.gold = gold;
		this.ep = ep;
		this.cost = cost;
		this.id = id;
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
	}

	JPanel spielfeld;
	
	public JPanel getSpielfeld() {
		return spielfeld;
	}

	public void setSpielfeld(JPanel spielfeld) {
		this.spielfeld = spielfeld;
	}

	public void ausführen() {

		Timer timer = new Timer(10, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				x = x + 1;
				Graphics g = spielfeld.getGraphics();
				g.setColor(spielfeld.getBackground());
				g.fillRect(0, 0, spielfeld.getWidth(), spielfeld.getHeight());// ------
				create();
			}
		});
		timer.start();


	}

	public void create(){

		Graphics g = spielfeld.getGraphics();
		GameObject a = new GameObject();
		g.drawImage(a.getImage(), x, y, 200, 300, null);
	}
}
