package de.dataport.cottonwar.gui;

import java.awt.Graphics;

import javax.swing.JPanel;

import de.dataport.cottonwar.objekte.Spielfeld;

public class Haupthint extends JPanel {

	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(Spielfeld.backgroundh, 0, 0, 400, 600,null);
	}
	
//
//	final JButton j = new JButton("Krieger");
//	final JButton k = new JButton("Ritter");
//	final JButton l = new JButton("Reiter");
//	final JButton m = new JButton("Ritter");
//	final JButton n = new JButton("Krieger");
//	final JButton o = new JButton("Reiter");
//	final JButton e1 = new JButton("Lord");
//	final JButton e2 = new JButton("Drache");
//	final JButton e3 = new JButton("Himmelswache");
//	final JButton e4 = new JButton("Lord");
//	final JButton e5 = new JButton("Drache");
//	final JButton e6 = new JButton("Himmelswache");
//	final JButton eStart1 = new JButton("Evolution");
//	final JButton eStart2 = new JButton("Evolution");
//
//	n.addMouseListener(new MouseAdapter() {
//		@Override
//		public void mouseClicked(MouseEvent arg0) {
//			if (gold2 >= 10) {
//				Einheit e = new Einheit("Krieger", 80, 20, 0, 15, 0, 10, 1, 890, 220, 128, 128, 20, 1000);
//				gold2 = gold2 - e.getCost();
//				r2.setText(gold2 + "");
//				Einheit.einheiten.add(e);
//				e.setSpielfeld(spielfeld);
//				e.ausführen();
//			}
//		}
//	});
//	m.addMouseListener(new MouseAdapter() {
//		@Override
//		public void mouseClicked(MouseEvent arg0) {
//			if (gold2 >= 15) {
//				Einheit e = new Einheit("Ritter", 200, 12, 0, 20, 0, 15, 1, 890, 220, 128, 128, 30, 1000);
//				gold2 = gold2 - e.getCost();
//				r2.setText(gold2 + "");
//				Einheit.einheiten.add(e);
//				e.setSpielfeld(spielfeld);
//				e.ausführen();
//			}
//		}
//	});
//	o.addMouseListener(new MouseAdapter() {
//		@Override
//		public void mouseClicked(MouseEvent arg0) {
//			if (gold2 >= 25) {
//				Einheit e = new Einheit("Reiter", 100, 20, 0, 30, 0, 25, 1, 890, 220, 128, 128, 10, 1000);
//				gold2 = gold2 - e.getCost();
//				r2.setText(gold2 + "");
//				Einheit.einheiten.add(e);
//				e.setSpielfeld(spielfeld);
//				e.ausführen();
//			}
//		}
//	});
//	j.addMouseListener(new MouseAdapter() {
//		@Override
//		public void mouseClicked(MouseEvent arg0) {
//			if (gold >= 10) {
//				Einheit e = new Einheit("Krieger", 100, 20, 0, 15, 0, 10, 0, 10, 220, 128, 128, 20, 1000);
//				gold = gold - e.getCost();
//				r.setText(gold + "");
//				Einheit.einheiten2.add(e);
//				e.setSpielfeld(spielfeld);
//				e.ausführen();
//			}
//		}
//	});
//	k.addMouseListener(new MouseAdapter() {
//		@Override
//		public void mouseClicked(MouseEvent arg0) {
//			if (gold >= 15) {
//				Einheit e = new Einheit("Ritter", 200, 12, 0, 20, 0, 15, 0, 10, 220, 128, 128, 30, 1000);
//				gold = gold - e.getCost();
//				r.setText(gold + "");
//				Einheit.einheiten2.add(e);
//				e.setSpielfeld(spielfeld);
//				e.ausführen();
//			}
//		}
//	});
//	l.addMouseListener(new MouseAdapter() {
//		@Override
//		public void mouseClicked(MouseEvent arg0) {
//			if (gold >= 25) {
//				Einheit e = new Einheit("Reiter", 80, 20, 0, 30, 0, 25, 0, 10, 220, 128, 128, 10, 1000);
//				gold = gold - e.getCost();
//				r.setText(gold + "");
//				Einheit.einheiten2.add(e);
//				e.setSpielfeld(spielfeld);
//				e.ausführen();
//			}
//		}
//	});
//
//	j.setBounds(10, 10, 90, 20);
//	k.setBounds(110, 10, 90, 20);
//	l.setBounds(210, 10, 90, 20);
//	o.setBounds(1060, 10, 90, 20);
//	m.setBounds(960, 10, 90, 20);
//	n.setBounds(860, 10, 90, 20);
//
//	e1.setBounds(10, 10, 90, 20);
//	e2.setBounds(110, 10, 90, 20);
//	e3.setBounds(210, 10, 90, 20);
//	e4.setBounds(1060, 10, 90, 20);
//	e5.setBounds(960, 10, 90, 20);
//	e6.setBounds(860, 10, 90, 20);
//	eStart1.setBounds(10, 40, 90, 20);
//	eStart2.setBounds(860, 40, 90, 20);
//
//	e1.addMouseListener(new MouseAdapter() {
//		@Override
//		public void mouseClicked(MouseEvent arg0) {
//			if (gold >= 40) {
//				Einheit e = new Einheit("Lord", 160, 30, 0, 45, 0, 40, 0, 10, 220, 128, 128, 30, 800);
//				gold = gold - e.getCost();
//				r.setText(gold + "");
//				Einheit.einheiten2.add(e);
//				e.setSpielfeld(spielfeld);
//				e.ausführen();
//			}
//		}
//	});
//	e2.addMouseListener(new MouseAdapter() {
//		@Override
//		public void mouseClicked(MouseEvent arg0) {
//			if (gold >= 45) {
//				Einheit e = new Einheit("Drache", 250, 40, 0, 50, 0, 45, 0, 10, 220, 128, 128, 20, 3000);
//				gold = gold - e.getCost();
//				r.setText(gold + "");
//				Einheit.einheiten2.add(e);
//				e.setSpielfeld(spielfeld);
//				e.ausführen();
//			}
//		}
//	});
//	e3.addMouseListener(new MouseAdapter() {
//		@Override
//		public void mouseClicked(MouseEvent arg0) {
//			if (gold >= 140) {
//				Einheit e = new Einheit("Himmelswacht", 400, 55, 0, 150, 0, 140, 0, 10, 220, 128, 128, 50, 4000);
//				gold = gold - e.getCost();
//				r.setText(gold + "");
//				Einheit.einheiten2.add(e);
//				e.setSpielfeld(spielfeld);
//				e.ausführen();
//			}
//		}
//	});
//	e4.addMouseListener(new MouseAdapter() {
//		@Override
//		public void mouseClicked(MouseEvent arg0) {
//			if (gold2 >= 40) {
//				Einheit e = new Einheit("Lord", 160, 30, 0, 45, 0, 40, 1, 890, 220, 128, 128, 30, 800);
//				gold2 = gold2 - e.getCost();
//				r2.setText(gold2 + "");
//				Einheit.einheiten.add(e);
//				e.setSpielfeld(spielfeld);
//				e.ausführen();
//			}
//		}
//	});
//	e5.addMouseListener(new MouseAdapter() {
//		@Override
//		public void mouseClicked(MouseEvent arg0) {
//			if (gold2 >= 45) {
//				Einheit e = new Einheit("Drache", 250, 40, 0, 50, 0, 45, 1, 890, 220, 128, 128, 20, 3000);
//				gold2 = gold2 - e.getCost();
//				r2.setText(gold2 + "");
//				Einheit.einheiten.add(e);
//				e.setSpielfeld(spielfeld);
//				e.ausführen();
//			}
//		}
//	});
//	e6.addMouseListener(new MouseAdapter() {
//		@Override
//		public void mouseClicked(MouseEvent arg0) {
//			if (gold2 >= 140) {
//				Einheit e = new Einheit("Himmelswacht", 400, 55, 0, 150, 0, 140, 1, 890, 220, 128, 128, 50, 4000);
//				gold2 = gold2 - e.getCost();
//				r2.setText(gold2 + "");
//				Einheit.einheiten.add(e);
//				e.setSpielfeld(spielfeld);
//				e.ausführen();
//			}
//		}
//	});
//	eStart1.addMouseListener(new MouseAdapter() {
//		@Override
//		public void mouseClicked(MouseEvent arg0) {
//			if (exp >= 5000) {
//				l.setVisible(false);
//				j.setVisible(false);
//				k.setVisible(false);
//				eStart1.setVisible(false);
//
//				w.add(e1);
//				w.add(e2);
//				w.add(e3);
//			}
//		}
//	});
//	eStart2.addMouseListener(new MouseAdapter() {
//		@Override
//		public void mouseClicked(MouseEvent arg0) {
//			if (exp >= 5000) {
//				n.setVisible(false);
//				m.setVisible(false);
//				o.setVisible(false);
//				eStart2.setVisible(false);
//
//				w.add(e4);
//				w.add(e5);
//				w.add(e6);
//			}
//		}
//	});
//
//	w.add(j);
//	w.add(k);
//	w.add(l);
//	w.add(o);
//	w.add(m);
//	w.add(n);
//	w.add(eStart1);
//	w.add(eStart2);

	
	
	
	
}
