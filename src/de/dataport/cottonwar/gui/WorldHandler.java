package de.dataport.cottonwar.gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Timer;

import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.Box;

import java.awt.BorderLayout;

import javax.swing.SwingConstants;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

import javax.swing.AbstractAction;

import java.awt.event.ActionEvent;

import javax.swing.Action;

import de.dataport.cottonwar.objekte.Einheit;
import de.dataport.cottonwar.objekte.Spielfeld;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class WorldHandler extends JFrame {

	World w;
	JPanel spielfeld;
	public static int gold;
	public static int gold2;
	public static int exp2;
	public static int exp;

	public static boolean evolution = false;

	public static ExecutorService executor = Executors.newCachedThreadPool();

	public WorldHandler() {

		JFrame worldhander = new JFrame();
		worldhander.setSize(1200, 700);
		worldhander.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		worldhander.setVisible(true);

		spielfeld = new Spielfeld();
		spielfeld.setBounds(10, 200, 1590, 870);

		gold = 100;
		gold2 = 100;
		exp2 = 0;
		exp = 0;
		w = new World();
		worldhander.setContentPane(w);
		getContentPane().setLayout(null);
		w.setLayout(null);
		w.add(spielfeld);

		Einheit basis1 = new Einheit("Basis", 600, 12, 0, 9000, 12000, 0, 0, 10, 150, 300, 300, 0, 1500);
		Einheit.einheiten2.add(basis1);
		basis1.setSpielfeld(spielfeld);
		basis1.ausführen();
		Einheit basis2 = new Einheit("Basis", 600, 12, 0, 9000, 12000, 0, 1, 890, 150, 300, 300, 0, 1500);
		Einheit.einheiten.add(basis2);
		basis2.setSpielfeld(spielfeld);
		basis2.ausführen();

		final JLabel r = new JLabel(gold + "");
		r.setBounds(360, 13, 46, 14);
		w.add(r);

		final JLabel r2 = new JLabel(gold2 + "");
		r2.setBounds(800, 13, 46, 14);
		w.add(r2);

		final JButton j = new JButton("Krieger");
		final JButton k = new JButton("Ritter");
		final JButton l = new JButton("Reiter");
		final JButton m = new JButton("Ritter");
		final JButton n = new JButton("Krieger");
		final JButton o = new JButton("Reiter");
		final JButton e1 = new JButton("Lord");
		final JButton e2 = new JButton("Drache");
		final JButton e3 = new JButton("Himmelswache");
		final JButton e4 = new JButton("Lord");
		final JButton e5 = new JButton("Drache");
		final JButton e6 = new JButton("Himmelswache");
		final JButton eStart1 = new JButton("Evolution");
		final JButton eStart2 = new JButton("Evolution");

		n.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (gold2 >= 25) {
					Einheit e = new Einheit("Krieger", 80, 20, 70, 25, 0, 25, 1, 890, 220, 128, 128, 20, 1000);
					gold2 = gold2 - e.getCost();
					r2.setText(gold2 + "");
					Einheit.einheiten.add(e);
					e.setSpielfeld(spielfeld);
					e.ausführen();
				}
			}
		});
		m.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (gold2 >= 20) {
					Einheit e = new Einheit("Ritter", 200, 12, 10, 20, 0, 15, 1, 890, 220, 128, 128, 30, 1000);
					gold2 = gold2 - e.getCost();
					r2.setText(gold2 + "");
					Einheit.einheiten.add(e);
					e.setSpielfeld(spielfeld);
					e.ausführen();
				}
			}
		});
		o.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (gold2 >= 15) {
					Einheit e = new Einheit("Reiter", 100, 20, 10, 15, 0, 10, 1, 890, 220, 128, 128, 10, 1000);
					gold2 = gold2 - e.getCost();
					r2.setText(gold2 + "");
					Einheit.einheiten.add(e);
					e.setSpielfeld(spielfeld);
					e.ausführen();
				}
			}
		});
		j.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (gold >= 15) {
					Einheit e = new Einheit("Krieger", 100, 20, 10, 15, 0, 10, 0, 10, 220, 128, 128, 20, 1000);
					gold = gold - e.getCost();
					r.setText(gold + "");
					Einheit.einheiten2.add(e);
					e.setSpielfeld(spielfeld);
					e.ausführen();
				}
			}
		});
		k.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (gold >= 20) {
					Einheit e = new Einheit("Ritter", 200, 12, 10, 20, 0, 15, 0, 10, 220, 128, 128, 30, 1000);
					gold = gold - e.getCost();
					r.setText(gold + "");
					Einheit.einheiten2.add(e);
					e.setSpielfeld(spielfeld);
					e.ausführen();
				}
			}
		});
		l.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (gold >= 30) {
					Einheit e = new Einheit("Reiter", 80, 20, 70, 15, 0, 25, 0, 10, 220, 128, 128, 10, 1000);
					gold = gold - e.getCost();
					r.setText(gold + "");
					Einheit.einheiten2.add(e);
					e.setSpielfeld(spielfeld);
					e.ausführen();
				}
			}
		});

		j.setBounds(10, 10, 90, 20);
		k.setBounds(110, 10, 90, 20);
		l.setBounds(210, 10, 90, 20);
		o.setBounds(1060, 10, 90, 20);
		m.setBounds(960, 10, 90, 20);
		n.setBounds(860, 10, 90, 20);

		e1.setBounds(10, 10, 90, 20);
		e2.setBounds(110, 10, 90, 20);
		e3.setBounds(210, 10, 90, 20);
		e4.setBounds(1060, 10, 90, 20);
		e5.setBounds(960, 10, 90, 20);
		e6.setBounds(860, 10, 90, 20);
		eStart1.setBounds(10, 40, 90, 20);
		eStart2.setBounds(860, 40, 90, 20);

		e1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (gold >= 15) {
					Einheit e = new Einheit("Lord", 160, 30, 10, 15, 0, 40, 0, 10, 220, 128, 128, 30, 800);
					gold = gold - e.getCost();
					r.setText(gold + "");
					Einheit.einheiten2.add(e);
					e.setSpielfeld(spielfeld);
					e.ausführen();
				}
			}
		});
		e2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (gold >= 20) {
					Einheit e = new Einheit("Drache", 200, 12, 10, 20, 0, 15, 0, 10, 220, 128, 128, 30, 1000);
					gold = gold - e.getCost();
					r.setText(gold + "");
					Einheit.einheiten2.add(e);
					e.setSpielfeld(spielfeld);
					e.ausführen();
				}
			}
		});
		e3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (gold >= 30) {
					Einheit e = new Einheit("Himmelswacht", 80, 20, 70, 15, 0, 25, 0, 10, 220, 128, 128, 10, 1000);
					gold = gold - e.getCost();
					r.setText(gold + "");
					Einheit.einheiten2.add(e);
					e.setSpielfeld(spielfeld);
					e.ausführen();
				}
			}
		});
		e4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (gold2 >= 25) {
					Einheit e = new Einheit("Lord", 160, 30, 10, 15, 0, 40, 0, 40, 220, 128, 128, 30, 800);
					gold2 = gold2 - e.getCost();
					r2.setText(gold2 + "");
					Einheit.einheiten.add(e);
					e.setSpielfeld(spielfeld);
					e.ausführen();
				}
			}
		});
		e5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (gold2 >= 25) {
					Einheit e = new Einheit("Drache", 80, 20, 70, 25, 0, 25, 1, 890, 220, 128, 128, 20, 1000);
					gold2 = gold2 - e.getCost();
					r2.setText(gold2 + "");
					Einheit.einheiten.add(e);
					e.setSpielfeld(spielfeld);
					e.ausführen();
				}
			}
		});
		e6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (gold2 >= 15) {
					Einheit e = new Einheit("Himmelswacht", 100, 20, 10, 15, 0, 10, 1, 890, 220, 128, 128, 10, 1000);
					gold2 = gold2 - e.getCost();
					r2.setText(gold2 + "");
					Einheit.einheiten.add(e);
					e.setSpielfeld(spielfeld);
					e.ausführen();
				}
			}
		});
		eStart1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (exp <= 5000) {
					l.setVisible(false);
					j.setVisible(false);
					k.setVisible(false);
					eStart1.setVisible(false);

					w.add(e1);
					w.add(e2);
					w.add(e3);
				}
			}
		});
		eStart2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (exp <= 5000) {
					n.setVisible(false);
					m.setVisible(false);
					o.setVisible(false);
					eStart2.setVisible(false);

					w.add(e4);
					w.add(e5);
					w.add(e6);
				}
			}
		});

		w.add(j);
		w.add(k);
		w.add(l);
		w.add(o);
		w.add(m);
		w.add(n);
		w.add(eStart1);
		w.add(eStart2);

		Timer timer = new Timer(1, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				spielfeld.repaint();
			}
		});
		timer.start();

		Timer timer2 = new Timer(2000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gold = gold + 1;
				gold2 = gold2 + 1;
				r.setText(gold + "");
				r2.setText(gold2 + "");
			}
		});
		timer2.start();

	}

	public int getGold1() {

		return gold;

	}

	public int getGold2() {

		return gold2;
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {

		}
	}
}
