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
	int lp, ap, spd, range, gold, ep, cost, id, x, y, height, width, speed = 10;
	Timer timer;
	Timer timer2;

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
		Einheit s = null;
		while (!stop) {
			
			stop = kollisionstest();
			s = welchesobjekt();
			if (s != null && s.id == id) {
				stop = false;
				continue;
			}
			x = x + (id == 0 ? 1 : -1);
			if (s!=null && s.id != id) {
				stop = angreifen(s);
			}
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

		List<Einheit> enemies = null;
		if (id == 0) {
			enemies = einheiten;
			Rectangle me = new Rectangle(x - 64 , y,64 , 10);
			for (Einheit e : enemies) {
				
				Rectangle enemy = new Rectangle(e.x - 64, e.y, 64, 10);

				if (me.intersects(enemy)) {
					angreifen(e);
					return true;
				}
			}
			enemies = einheiten2;
			for (Einheit k : enemies ) {
				
				Rectangle freund = new Rectangle(k.x-64, k.y,64,10);
				
				if (me.intersects(freund) && k.x != x){
					return true;
				}
			}
				
			}else {
				enemies = einheiten2;
				Rectangle me = new Rectangle(x - 64 , y,64 , 10);
				for (Einheit e : enemies) {
					
					Rectangle enemy = new Rectangle(e.x - 64, e.y, 64, 10);

					if (me.intersects(enemy)) {
						angreifen(e);
						return true;
					}
				}
				enemies = einheiten;
				for (Einheit k : enemies ) {
					
					Rectangle freund = new Rectangle(k.x-64, k.y,64,10);
					
					if (me.intersects(freund) && k.x != x){
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
			Rectangle me = new Rectangle(x - 64 , y,64 , 10);
			for (Einheit e : enemies) {
				
				Rectangle enemy = new Rectangle(e.x - 64, e.y, 64, 10);

				if (me.intersects(enemy)) {
					return(e);
				}
			}
			enemies = einheiten2;
			for (Einheit k : enemies ) {
				
				Rectangle freund = new Rectangle(k.x-64, k.y,64,10);
				
				if (me.intersects(freund) && k.x != x){
					return k;
				}
			}
				
			}else {
				enemies = einheiten2;
				Rectangle me = new Rectangle(x - 64 , y,64 , 10);
				for (Einheit e : enemies) {
					
					Rectangle enemy = new Rectangle(e.x - 64, e.y, 64, 10);

					if (me.intersects(enemy)) {
						return(e);
					}
				}
				enemies = einheiten;
				for (Einheit k : enemies ) {
					
					Rectangle freund = new Rectangle(k.x-64, k.y,64,10);
					
					if (me.intersects(freund) && k.x != x){
						return k;
					}
			}
			
		}
		
		return null;
	
}
	
	public int random() {
		int zufall;
		double ran = Math.random();
		
		zufall = (int)(ran*5) +1;
		System.out.println(zufall);
		return zufall;
		
	}
	
	public boolean angreifen(Einheit e) {
		while(0 <= e.lp) {
			
			if (lp<=0) {
				break;
			}
			
			e.lp = e.lp - (ap + random());
			
			try {
				Thread.sleep(spd);
			} catch (InterruptedException e1) {
				}
			
			
			
		}
		if (lp > e.lp) {
			if (id ==0) {
				einheiten.remove(e);
				e = null;
				return false;
			} else {
				einheiten2.remove(e);
				e = null;
				return false;
			}
		}else {
			return true;
		}
	}
	
	
}
