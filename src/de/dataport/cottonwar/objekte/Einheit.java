package de.dataport.cottonwar.objekte;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.Timer;

import de.dataport.cottonwar.gui.WorldHandler;

public class Einheit implements Runnable {

	public static List<Einheit> einheiten = new ArrayList<Einheit>();
	public static List<Einheit> einheiten2 = new ArrayList<Einheit>();

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
	int lp, ap, spd, range, gold, ep, cost, id, x, y, height, width,
			speed = 10;
	Timer timer;
	Timer timer2;

	public Einheit(String name, int lp, int ap, int range, int gold, int ep,
			int cost, int id, int x, int y, int height, int width, int speed) {
		super();
		this.name = name;
		this.lp = lp;
		this.ap = ap;
		this.range = range;
		this.gold = gold;
		this.ep = ep;
		this.cost = cost;
		this.id = id;
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
		this.speed = speed;
	}

	static JPanel spielfeld;

	public static JPanel getSpielfeld() {
		return spielfeld;
	}

	public void setSpielfeld(JPanel spielfeld) {
		this.spielfeld = spielfeld;
	}

	@Override
	public void run() {
		boolean stop = false;
		while (!stop) {
			x = x + (id == 0 ? 1 : -1);
			stop = kollisionstest();
			try {
				Thread.sleep(speed);
			} catch (InterruptedException e) {
			}
		}
	}

	public void ausführen() {
		WorldHandler.executor.execute(this);
	}

	public void zeichnen() {

		Timer timer = new Timer(10, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Graphics g = spielfeld.getGraphics();
				g.setColor(spielfeld.getBackground());
				g.fillRect(0, 0, spielfeld.getWidth(), spielfeld.getHeight());

			}

		});
		timer.start();

	}

	public boolean kollisionstest() {

		List<Einheit> enemies = einheiten2;
		if (id == 0)
			enemies = einheiten;
		
		Rectangle me = new Rectangle(x - 64, y, 64, 10);//breite der Figuren mit Parameter übergeben
		
		for (Einheit e : enemies) {
			Rectangle enemy = new Rectangle(e.x - 64, e.y, 64, 10);

			if (me.intersects(enemy)) {
				einheiten.remove(me);
				einheiten2.remove(enemy);
				System.out.println("Attacke");
				return true;
			}
		}
		return false;
	}

	 public int attacke(){
	
	 if(kollisionstest() == true){
	
		 e.lp = e.lp - .ap * Math.random();
	 }
	 }

}
