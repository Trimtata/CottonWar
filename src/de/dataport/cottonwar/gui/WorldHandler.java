package de.dataport.cottonwar.gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.Timer;

import java.awt.Color;
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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JTextField;
import javax.swing.JLabel;

public class WorldHandler extends JFrame implements KeyListener {

	World w;
	JPanel spielfeld;
	public static int gold;
	public static int gold2;
	public static int exp2;
	public static int exp;
	public static int lp;
	public static int lp2;

	public static boolean evolution1 = false;
	public static boolean evolution2 = false;

	public static ExecutorService executor = Executors.newCachedThreadPool();

	public WorldHandler() {
		setSize(1210, 740);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
		
		spielfeld = new Spielfeld();
		spielfeld.setBounds(35, 238, 1124, 435);
		w = new World();
		setContentPane(w);
		getContentPane().setLayout(null);
		w.setLayout(null);
		
		addKeyListener(this);
		this.requestFocusInWindow();
		gold = 100;
		gold2 = 100;

		exp2 = 0;
		exp = 0;
		
		
		w.add(spielfeld);
		
		
		final Einheit basis1 = new Einheit("Basis1", 1000, 12, 0, 9000, 12000, 0, 0, -20, 50, 300, 300, 0, 1500);
		Einheit.einheiten2.add(basis1);
		basis1.setSpielfeld(spielfeld);
		basis1.ausf�hren();
		final Einheit basis2 = new Einheit("Basis2", 1000, 12, 0, 9000, 12000, 0, 1, 890, 30, 300, 300, 0, 1500);
		Einheit.einheiten.add(basis2);
		basis2.setSpielfeld(spielfeld);
		basis2.ausf�hren();

		final JLabel r = new JLabel(gold + "");
		r.setBounds(99, 99, 46, 14);
		r.setForeground(Color.yellow);
		w.add(r);
		final JLabel r2 = new JLabel(gold2 + "");
		r2.setBounds(1077, 99, 46, 14);
		r2.setForeground(Color.yellow);
		w.add(r2);
		final JLabel ex1 = new JLabel(exp + "");
		ex1.setBounds(99, 135, 46, 14);
		ex1.setForeground(Color.yellow);
		w.add(ex1);
		final JLabel ex2 = new JLabel(exp2 + "");
		ex2.setBounds(1077, 141, 46, 14);
		ex2.setForeground(Color.yellow);
		w.add(ex2);
		final JLabel evo1 = new JLabel("Primitiv");
		evo1.setBounds(63,176,100,14);
		evo1.setForeground(Color.yellow);
		w.add(evo1);
		final JLabel evo2 = new JLabel("Primitiv");
		evo2.setBounds(1036,176,107,14);
		evo2.setForeground(Color.yellow);
		w.add(evo2);

		Timer timer = new Timer(1, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				spielfeld.repaint();
			}
		});
		timer.start();

		Timer timer2 = new Timer(1600, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gold = gold + 1;
				gold2 = gold2 + 1;
				lp = basis1.getLp();
				lp2 = basis2.getLp();
				r.setText(gold + "");
				r2.setText(gold2 + "");
				ex1.setText(exp + "");
				ex2.setText(exp2 + "");
				if (evolution1 == true) {
					ex1.setText("Fortschrittlich");
				}
				if (evolution2 == true) {
					ex2.setText("Fortschrttlich");
				}
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
	
	public int getEx2() {
		return exp2;
	}
	public int getEx1() {
		return exp;
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {

		}
	}

	@Override
	public void keyPressed(KeyEvent s) {
		if (s.getKeyChar() == 'q') {
			if (gold >= 10) {
				Einheit e = new Einheit("Krieger1", 100, 20, 0, 15, 50, 10, 0, -20, 150, 128, 128, 20, 1000);
				gold = gold - e.getCost();
				Einheit.einheiten2.add(e);
				e.setSpielfeld(spielfeld);
				e.ausf�hren();
			}
		}
		if (s.getKeyChar() == 'w') {
			if (gold >= 15) {
				Einheit e = new Einheit("Ritter1", 200, 12, 0, 20, 100, 15, 0, 10, 150, 128, 128, 30, 1000);
				gold = gold - e.getCost();
				Einheit.einheiten2.add(e);
				e.setSpielfeld(spielfeld);
				e.ausf�hren();
			}
		}
		if (s.getKeyChar() == 'e') {
			if (gold >= 25) {
				Einheit e = new Einheit("Reiter1", 80, 20, 0, 30, 120, 25, 0, 10, 150, 128, 128, 10, 1000);
				gold = gold - e.getCost();
				Einheit.einheiten2.add(e);
				e.setSpielfeld(spielfeld);
				e.ausf�hren();
			}
		}
		if (s.getKeyChar() == 'a') {
			if (evolution2==true){
			if (gold >= 40) {
				Einheit e = new Einheit("Lord1", 160, 30, 0, 45, 200, 40, 0, 10, 150, 128, 128, 30, 800);
				gold = gold - e.getCost();
				Einheit.einheiten2.add(e);
				e.setSpielfeld(spielfeld);
				e.ausf�hren();
			}
			} else {
				
			}
		}
		if (s.getKeyChar() == 's') {
			if (evolution2==true){
			if (gold >= 45) {
				Einheit e = new Einheit("Drache1", 250, 40, 0, 50, 300, 45, 0, 10, 150, 128, 128, 20, 3000);
				gold = gold - e.getCost();
				Einheit.einheiten2.add(e);
				e.setSpielfeld(spielfeld);
				e.ausf�hren();
			}
			}else {
				
			}
		}
		if (s.getKeyChar() == 'd') {
			if (evolution1==true){
			if (gold >= 140) {
				Einheit e = new Einheit("Himmelswacht1", 400, 55, 0, 150, 400, 140, 0, 10, 150, 128, 128, 50, 4000);
				gold = gold - e.getCost();
				Einheit.einheiten2.add(e);
				e.setSpielfeld(spielfeld);
				e.ausf�hren();
			}
			}else {
				
			}
		}
		if (s.getKeyChar() == 'x') {
			if (evolution1 == false && exp>=5000) {
				evolution1 = true;
			}else {
				
			}
		}
		if (s.getKeyChar() == 'i') {
			if (gold2 >= 10) {
				Einheit e = new Einheit("Krieger2", 80, 20, 0, 15, 50, 10, 1, 890, 150, 128, 128, 20, 1000);
				gold2 = gold2 - e.getCost();
				Einheit.einheiten.add(e);
				e.setSpielfeld(spielfeld);
				e.ausf�hren();
			}
		}
		if (s.getKeyChar() == 'o') {
			if (gold2 >= 15) {
				Einheit e = new Einheit("Ritter2", 200, 12, 0, 20, 100, 15, 1, 890, 150, 128, 128, 30, 1000);
				gold2 = gold2 - e.getCost();
				Einheit.einheiten.add(e);
				e.setSpielfeld(spielfeld);
				e.ausf�hren();
			}
		}
		if (s.getKeyChar() == 'p') {
			if (gold2 >= 25) {
				Einheit e = new Einheit("Reiter2", 100, 20, 0, 30, 120, 25, 1, 890, 150, 128, 128, 10, 1000);
				gold2 = gold2 - e.getCost();
				Einheit.einheiten.add(e);
				e.setSpielfeld(spielfeld);
				e.ausf�hren();
			}
		}
		if (s.getKeyChar() == 'j') {
			if (evolution2==true){
			if (gold2 >= 40) {
				Einheit e = new Einheit("Lord2", 160, 30, 0, 45, 200, 40, 1, 890, 150, 128, 128, 30, 800);
				gold2 = gold2 - e.getCost();
				Einheit.einheiten.add(e);
				e.setSpielfeld(spielfeld);
				e.ausf�hren();
			}
			} else {
				
			}
		}
		if (s.getKeyChar() == 'k') {
			if (evolution2==true){
			if (gold2 >= 45) {
				Einheit e = new Einheit("Drache2", 250, 40, 0, 50, 300, 45, 1, 890, 150, 128, 128, 20, 3000);
				gold2 = gold2 - e.getCost();
				Einheit.einheiten.add(e);
				e.setSpielfeld(spielfeld);
				e.ausf�hren();
			}
			} else {
				
			}
		}
		if (s.getKeyChar() == 'l') {
			if (evolution2==true){
			if (gold2 >= 140) {
				Einheit e = new Einheit("Himmelswacht2", 400, 55, 0, 150, 400, 140, 1, 890, 150, 128, 128, 50, 4000);
				gold2 = gold2 - e.getCost();
				Einheit.einheiten.add(e);
				e.setSpielfeld(spielfeld);
				e.ausf�hren();
			}
			} else {
				
			}
		}
		if (s.getKeyChar() == 'm') {
			if (evolution2 == false && exp2>=5000) {
				evolution2 = true;
			}else {
				
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
