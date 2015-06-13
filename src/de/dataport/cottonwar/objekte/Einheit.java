package de.dataport.cottonwar.objekte;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import de.dataport.cottonwar.gui.WorldHandler;

public class Einheit implements Runnable {

	public static List<Einheit> einheiten = new ArrayList<Einheit>();

	public static List<Einheit> einheiten2 = new ArrayList<Einheit>();

	public int getLp() {
		return lp;
	}
	
	public int getX() {
		return x;
	}
	public int getCost() {
		return cost;
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

	public int getGold() {
		return gold;
	}

	String name;
	int lp, ap, spd, range, gold, ep, cost, id, x, y, height, width, speed = 10;
	Timer timer;
	Timer timer2;
	public Image image;

	public Einheit(String name, int lp, int ap, int range, int gold, int ep, int cost, int id, int x, int y, int height, int width,
			int speed, int spd) {
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
		this.spd = spd;

		if (name.equals("Basis1")) {
			this.image = Spielfeld.Basis0;
		}
		if (name.equals("Basis2")) {
			this.image = Spielfeld.Basis;
		}
		if (name.equals("Krieger1")) {
			this.image = Spielfeld.Krieger0;
		}
		if (name.equals("Krieger2")) {
			this.image = Spielfeld.Krieger;
		}
		if (name.equals("Ritter1")) {
			this.image = Spielfeld.Ritter0;
		}
		if (name.equals("Ritter2")) {
			this.image = Spielfeld.Ritter;
		}
		if (name.equals("Reiter1")) {
			this.image = Spielfeld.Reiter0;
		}
		if (name.equals("Reiter2")) {
			this.image = Spielfeld.Reiter;
		}
		if (name.equals("Lord1")) {
			this.image = Spielfeld.Lord0;
		}
		if (name.equals("Lord2")) {
			this.image = Spielfeld.Lord;
		}
		if (name.equals("Drache1")) {
			this.image = Spielfeld.Drache0;
		}
		if (name.equals("Drache2")) {
			this.image = Spielfeld.Drache;
		}
		if (name.equals("Himmelswache1")) {
			this.image = Spielfeld.Himmelswacht0;
		}
		if (name.equals("Himmelswache2")) {
			this.image = Spielfeld.Himmelswacht;
		}
		

	}

	static JPanel spielfeld;

	public static JPanel getSpielfeld() {
		return spielfeld;
	}

	public void setSpielfeld(JPanel spielfeld) {
		this.spielfeld = spielfeld;
	}

	boolean hasStopped;

	@Override
	public void run() {
		
		boolean stop = false;
		Einheit s = null;
		while (!stop) {
			if (this.name == "Basis1" || this.name == "Basis2") {
			break;
		}
			synchronized (einheiten) {
				stop = kollisionstest();
				s = welchesobjekt();
			}
//			if (hasStopped)
//				System.out.println("coll: " + stop + " " + s + (s != null ? s.id : ""));
			
			if (s != null && s.id == id) {
				stop = false;
				
//				System.out.println("stopped");
				
//				hasStopped = true;
				sleep();
				continue;
			}
			
//			if (hasStopped)
//				System.out.println("moving a step " + stop);
			
			x = x + (id == 0 ? 1 : -1);
			if (s != null && s.id != id) {
				stop = angreifen(s);
				if (stop == true) {
					break;
				}
			}
			sleep();
		}

	}

	public void sleep() {
		try {
			Thread.sleep(speed);
		} catch (InterruptedException e) {
		}
	}

	public synchronized boolean angreifen(Einheit e) {
		while (0 <= e.lp) {

			if (lp <= 0) {
				break;
			}

			e.lp = e.lp - (ap + random());

			try {
				Thread.sleep(spd);
			} catch (InterruptedException e1) {
			}

		}
		if (lp > e.lp) {
			if (id == 0) {
				WorldHandler.exp = WorldHandler.exp + e.ep;
				WorldHandler.gold = WorldHandler.gold + e.gold;
				einheiten.remove(e);
				if (e.name == "Basis2") {
					Object[] options = { "OK" };
					JOptionPane.showOptionDialog(null, "Spieler 1 hat das Spiel gewonnen!", "Glückwunsch", JOptionPane.DEFAULT_OPTION,
							JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					System.exit(0);
				}
				return false;
			} else {
				WorldHandler.exp2 = WorldHandler.exp2 + e.ep;
				WorldHandler.gold2 = WorldHandler.gold2 + e.gold;
				einheiten2.remove(e);
				if (e.name == "Basis1") {
					Object[] options = { "OK" };
					JOptionPane.showOptionDialog(null, "Spieler 2 hat das Spiel gewonnen!", "Glückwunsch", JOptionPane.DEFAULT_OPTION,
							JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					System.exit(0);
				}
				return false;
			}
		}
		return true;

	}

	public void ausführen() {
		WorldHandler.executor.execute(this);
	}

//	public void zeichnen() {
//
//		Timer timer = new Timer(10, new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				Graphics g = spielfeld.getGraphics();
//
//				g.setColor(spielfeld.getBackground());
//				g.fillRect(0, 0, spielfeld.getWidth(), spielfeld.getHeight());
//
//			}
//
//		});
//
//		timer.start();
//
//	}

	public boolean kollisionstest() {

		List<Einheit> enemies = null;
		if (id == 0) {
			enemies = einheiten;
			Rectangle me = new Rectangle(x - 64, y, 64, 10);
			for (Einheit e : enemies) {

				Rectangle enemy = new Rectangle(e.x - 64, e.y, 64, 400);

				if (me.intersects(enemy)) {
					// angreifen(e);
					return true;
				}
			}
			enemies = einheiten2;
			for (Einheit k : enemies) {

				Rectangle freund = new Rectangle(k.x - 64, k.y, 64, 400);

				if (me.intersects(freund) && k.x != x && k.x > x) {
					if (k.name == "Basis")
						return false;
					return true;
				}
			}

		} else {
			enemies = einheiten2;
			Rectangle me = new Rectangle(x - 64, y, 64, 10);
			for (Einheit e : enemies) {
				
				Rectangle enemybase = new Rectangle(e.x,e.y,120,400);
				

				Rectangle enemy = new Rectangle(e.x - 64, e.y, 64, 400);
				
				

				if (me.intersects(enemy)) {
					// angreifen(e);
					return true;
				}
				if (me.intersects(enemybase)) {
					if (e.name == "Basis1") {
						return true;
					}
				}
			}
			enemies = einheiten;
			for (Einheit k : enemies) {

				Rectangle freund = new Rectangle(k.x - 64, k.y, 64, 400);

				if (me.intersects(freund) && k.x != x && k.x < x) {
					if (k.name =="Basis") {
						return false;
					}
					return true;
				}
			}

		}
		return false;

	}

	public Einheit welchesobjekt() {

		List<Einheit> enemies = null;
		if (id == 0) {
			enemies = einheiten;
			Rectangle me = new Rectangle(x - 64, y, 64, 10);
			for (Einheit e : enemies) {

				Rectangle enemy = new Rectangle(e.x - 64, e.y, 64, 400);

				if (me.intersects(enemy)) {
					return (e);
				}
			}
			enemies = einheiten2;
			for (Einheit k : enemies) {

				Rectangle freund = new Rectangle(k.x - 64, k.y, 64, 400);

				if (me.intersects(freund) && k.x != x && k.x > x) {
					if (k.name == "Basis") {
						return null;
					}
					return k;
				}
			}

		} else {
			enemies = einheiten2;
			Rectangle me = new Rectangle(x - 64, y, 64, 10);
			for (Einheit e : enemies) {

				Rectangle enemy = new Rectangle(e.x - 64, e.y, 64, 400);

				if (me.intersects(enemy)) {
					return (e);
				}
			}
			enemies = einheiten;
			for (Einheit k : enemies) {

				Rectangle freund = new Rectangle(k.x - 64, k.y, 64, 400);

				if (me.intersects(freund) && k.x != x && k.x < x) {
					if (k.name == "Basis") {
						return null;
					}
					return k;
				}
			}

		}

		return null;

	}

	public int random() {
		int zufall;
		zufall = (int) (Math.random() * 5) + 1;
		return zufall;

	}

}
