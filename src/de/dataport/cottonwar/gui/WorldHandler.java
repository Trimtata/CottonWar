package de.dataport.cottonwar.gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Window;

import javax.swing.Box;

import java.awt.BorderLayout;

import javax.swing.SwingConstants;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

import javax.swing.AbstractAction;

import java.awt.event.ActionEvent;

import javax.swing.Action;

import de.dataport.cottonwar.RMI.LpGoldExp;
import de.dataport.cottonwar.RMI.RMIClient;
import de.dataport.cottonwar.RMI.Service;
import de.dataport.cottonwar.objekte.Einheit;
import de.dataport.cottonwar.objekte.Spielfeld;
import de.dataport.cottonwar.savegame.*;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JTextField;
import javax.swing.JLabel;

public class WorldHandler extends JFrame implements KeyListener {

	World w;
	public static WorldHandler instance;
	JPanel spielfeld;
	public static Integer gold;
	public static int gold2;
	public static int exp2;
	public static int exp;
	public static int lp;
	public static int lp2;
	public boolean remoteGame;
	JButton btnSave = new JButton();

	Service service;
	RMIClient client;

	public static Integer getGold() {
		return gold;
	}

	public static void setGold(Integer gold) {
		WorldHandler.gold = gold;
	}

	public static int getGold2() {
		return gold2;
	}

	public static int getExp2() {
		return exp2;
	}

	public static void setExp2(int exp2) {
		WorldHandler.exp2 = exp2;
	}

	public static int getExp() {
		return exp;
	}

	public static void setExp(int exp) {
		WorldHandler.exp = exp;
	}

	public static int getLp() {
		return lp;
	}

	public static void setLp(int lp) {
		WorldHandler.lp = lp;
	}

	public static int getLp2() {
		return lp2;
	}

	public static void setLp2(int lp2) {
		WorldHandler.lp2 = lp2;
	}

	public static boolean isEvolution1() {
		return evolution1;
	}

	public static void setEvolution1(boolean evolution1) {
		WorldHandler.evolution1 = evolution1;
	}

	public static boolean isEvolution2() {
		return evolution2;
	}

	public static void setEvolution2(boolean evolution2) {
		WorldHandler.evolution2 = evolution2;
	}

	public static void setGold2(int gold2) {
		WorldHandler.gold2 = gold2;
	}

	public static boolean evolution1 = false;
	public static boolean evolution2 = false;

	public static ExecutorService executor = Executors.newCachedThreadPool();

	public WorldHandler() {
		instance = this;
		this.setSize(1210, 740);
		this.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);

		spielfeld = new Spielfeld();
		spielfeld.setBounds(35, 238, 1124, 435);
		w = new World();
		setContentPane(w);
		getContentPane().setLayout(null);
		w.setLayout(null);
		spielfeld.setLayout(null);

		addKeyListener(this);
		this.requestFocusInWindow();

		w.add(spielfeld);

		gold = 25;
		gold2 = 25;
		exp2 = 0;
		exp = 0;
		lp = 1000;
		lp2 = 1000;

		final Einheit basis1 = new Einheit("Basis1", 1000, 12, 0, 9000, 12000, 0, 0, -20, 50, 300, 300, 0, 1500);

		Einheit.einheiten2.add(basis1);
		basis1.setSpielfeld(spielfeld);
		basis1.ausführen();
		final Einheit basis2 = new Einheit("Basis2", 1000, 12, 0, 9000, 12000, 0, 1, 890, 30, 300, 300, 0, 1500);
		Einheit.einheiten.add(basis2);
		basis2.setSpielfeld(spielfeld);
		basis2.ausführen();

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
		evo1.setBounds(63, 176, 100, 14);
		evo1.setForeground(Color.yellow);
		w.add(evo1);
		final JLabel evo2 = new JLabel("Primitiv");
		evo2.setBounds(1036, 176, 107, 14);
		evo2.setForeground(Color.yellow);
		w.add(evo2);
		final JLabel hp1 = new JLabel("1000");
		final JLabel hp2 = new JLabel("1000");
		hp1.setBounds(10, 0, 250, 40);
		hp2.setBounds(1074, 0, 250, 40);
		hp1.setForeground(Color.red);
		hp2.setForeground(Color.red);
		spielfeld.add(hp1);
		spielfeld.add(hp2);

		btnSave = new JButton("Speichern & Schließen");
		btnSave.setBounds(179, 11, 167, 23);
		w.add(btnSave);
		btnSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Main.speichern();
				Object[] options = { "OK" };
				JOptionPane.showOptionDialog(null, "Ihr Spiel wurde gespeichert!", "Speichern", JOptionPane.DEFAULT_OPTION,
						JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

				System.exit(0);

			}
		});

		Timer timer = new Timer(1, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (remoteGame && RMIClient.client != null) {
					try {
						LpGoldExp s = RMIClient.stub.getLpGoldExp();
						WorldHandler.instance.setWerte(s);
					} catch (RemoteException e1) {
						e1.printStackTrace();
						System.exit(0);
					}

				}

				spielfeld.repaint();
			}
		});
		timer.start();

		Timer timer2 = new Timer(2000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gold = gold + 1;
				gold2 = gold2 + 1;

				lp = basis1.getLp();
				lp2 = basis2.getLp();
				hp1.setText(lp + " " + (remoteGame ? (RMIClient.client != null ? "client" : "server") : ""));
				hp2.setText(lp2 + "");
				r.setText(gold + "");
				r2.setText(gold2 + "");
				ex1.setText(exp + "");
				ex2.setText(exp2 + "");
				if (evolution1 == true) {
					evo1.setText("Fortschrittlich");
				}
				if (evolution2 == true) {
					evo2.setText("Fortschrttlich");
				}

				setGold(gold);
				setGold2(gold2);
				setExp(exp);
				setExp2(exp2);
				setLp(lp);
				setLp2(lp2);
				setEvolution1(evolution1);
				setEvolution2(evolution2);

			}
		});
		timer2.start();

	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {

		}
	}

	public void createKrieger(boolean firstPlayer) {
		if (remoteGame && RMIClient.client != null) {
			// Only client executes this block
			try {
				RMIClient.stub.createKrieger();
				return;
			} catch (RemoteException e) {
				e.printStackTrace();
				System.exit(0);
			}
		}

		if (firstPlayer) {
			if (gold >= 10) {
				Einheit e = new Einheit("Krieger1", 100, 20, 0, 2, 220, 10, 0, -20, 150, 128, 128, 20, 1100);
				gold = gold - e.getCost();
				Einheit.einheiten2.add(e);
				e.setSpielfeld(spielfeld);
				e.ausführen();
			}
		}
		if (!firstPlayer) {
			if (gold2 >= 10) {
				Einheit e = new Einheit("Krieger2", 100, 20, 0, 2, 220, 10, 1, 930, 150, 128, 128, 20, 1100);
				gold2 = gold2 - e.getCost();
				Einheit.einheiten.add(e);
				e.setSpielfeld(spielfeld);
				e.ausführen();
			}
		}
	}
	
	public void createRitter(boolean firstPlayer) {
		if (remoteGame && RMIClient.client != null) {
			// Only client executes this block
			try {
				RMIClient.stub.createRitter();
				return;
			} catch (RemoteException e) {
				e.printStackTrace();
				System.exit(0);
			}
		}

		if (firstPlayer) {
			if (gold >= 15) {
				Einheit e = new Einheit("Ritter1", 200, 15, 0, 7, 310, 15, 0, 10, 150, 128, 128, 40, 1000);
				gold = gold - e.getCost();
				Einheit.einheiten2.add(e);
				e.setSpielfeld(spielfeld);
				e.ausführen();
			}
		}
		if (!firstPlayer) {
			if (gold2 >= 15) {
				Einheit e = new Einheit("Ritter2", 200, 15, 0, 7, 310, 15, 1, 930, 150, 128, 128, 40, 1000);
				gold2 = gold2 - e.getCost();
				Einheit.einheiten.add(e);
				e.setSpielfeld(spielfeld);
				e.ausführen();
			}
		}
	}
	public void createReiter(boolean firstPlayer) {
		if (remoteGame && RMIClient.client != null) {
			// Only client executes this block
			try {
				RMIClient.stub.createReiter();
				return;
			} catch (RemoteException e) {
				e.printStackTrace();
				System.exit(0);
			}
		}

		if (firstPlayer) {
			if (gold >= 25) {
				Einheit e = new Einheit("Reiter1", 160, 30, 0, 12, 360, 25, 0, 10, 150, 128, 128, 10, 1000);
				gold = gold - e.getCost();
				Einheit.einheiten2.add(e);
				e.setSpielfeld(spielfeld);
				e.ausführen();
			}
		}
		if (!firstPlayer) {
			if (gold2 >= 25) {
				Einheit e = new Einheit("Reiter2", 160, 30, 0, 12, 360, 25, 1, 930, 150, 128, 128, 10, 1000);
				gold2 = gold2 - e.getCost();
				Einheit.einheiten.add(e);
				e.setSpielfeld(spielfeld);
				e.ausführen();
			}
		}
	}
	public void createLord(boolean firstPlayer) {
		if (remoteGame && RMIClient.client != null) {
			// Only client executes this block
			try {
				RMIClient.stub.createLord();
				return;
			} catch (RemoteException e) {
				e.printStackTrace();
				System.exit(0);
			}
		}

		if (firstPlayer) {
			if (evolution2 == true) {
				if (gold2 >= 40) {
					Einheit e = new Einheit("Lord1", 220, 45, 0, 65, 200, 40, 0, 10, 150, 128, 128, 30, 800);
					gold2 = gold2 - e.getCost();
					Einheit.einheiten.add(e);
					e.setSpielfeld(spielfeld);
					e.ausführen();
				}
			} else {

			}
		}
		if (!firstPlayer) {
			if (evolution2 == true) {
				if (gold2 >= 40) {
					Einheit e = new Einheit("Lord2", 220, 45, 0, 65, 200, 40, 1, 930, 150, 128, 128, 30, 800);
					gold2 = gold2 - e.getCost();
					Einheit.einheiten.add(e);
					e.setSpielfeld(spielfeld);
					e.ausführen();
				}
			} else {

			}
		}
	}
	public void createDrache(boolean firstPlayer) {
		if (remoteGame && RMIClient.client != null) {
			// Only client executes this block
			try {
				RMIClient.stub.createDrache();
				return;
			} catch (RemoteException e) {
				e.printStackTrace();
				System.exit(0);
			}
		}

		if (firstPlayer) {
			if (evolution2 == true) {
				if (gold >= 45) {
					Einheit e = new Einheit("Drache1", 250, 40, 0, 70, 300, 45, 0, 10, 150, 128, 128, 8, 700);
					gold = gold - e.getCost();
					Einheit.einheiten2.add(e);
					e.setSpielfeld(spielfeld);
					e.ausführen();
				}
			} else {

			}
		}
		if (!firstPlayer) {
			if (evolution2 == true) {
				if (gold2 >= 45) {
					Einheit e = new Einheit("Drache2", 250, 40, 0, 70, 300, 45, 1, 930, 150, 128, 128, 8, 700);
					gold2 = gold2 - e.getCost();
					Einheit.einheiten.add(e);
					e.setSpielfeld(spielfeld);
					e.ausführen();
				}
			} else {

			}
		}
	}
	public void createHimmelswacht(boolean firstPlayer) {
		if (remoteGame && RMIClient.client != null) {
			// Only client executes this block
			try {
				RMIClient.stub.createHimmelswacht();
				return;
			} catch (RemoteException e) {
				e.printStackTrace();
				System.exit(0);
			}
		}

		if (firstPlayer) {
			if (evolution1 == true) {
				if (gold >= 140) {
					Einheit e = new Einheit("Himmelswacht1", 400, 70, 0, 55, 400, 140, 0, 10, 150, 128, 128, 50, 900);
					gold = gold - e.getCost();
					Einheit.einheiten2.add(e);
					e.setSpielfeld(spielfeld);
					e.ausführen();
				}
			} else {

			}
		}
		if (!firstPlayer) {
			if (evolution2 == true) {
				if (gold2 >= 140) {
					Einheit e = new Einheit("Himmelswacht2", 400, 70, 0, 55, 400, 140, 1, 930, 150, 128, 128, 50, 900);
					gold2 = gold2 - e.getCost();
					Einheit.einheiten.add(e);
					e.setSpielfeld(spielfeld);
					e.ausführen();
				}
			} else {

			}
		}
	}

	@Override
	public void keyPressed(KeyEvent s) {
		if (s.getKeyChar() == 'q') {
			createKrieger(RMIClient.client == null);
		}
		if (s.getKeyChar() == 'w') {
			createRitter(remoteGame);
		}
		if (s.getKeyChar() == 'e') {
			createReiter(remoteGame);
		}
		if (s.getKeyChar() == 'a') {
			createLord(remoteGame);
		}
		if (s.getKeyChar() == 's') {
			createDrache(remoteGame);
		}
		if (s.getKeyChar() == 'd') {
			createHimmelswacht(remoteGame);
		}
		if (s.getKeyChar() == 'x') {
			if (evolution1 == false && exp >= 5000) {
				evolution1 = true;
			} else {

			}
		}
		if (s.getKeyChar() == 'i') {
			createKrieger(remoteGame);
		}
		if (s.getKeyChar() == 'o') {
			createRitter(remoteGame);
		}
		if (s.getKeyChar() == 'p') {
			createReiter(remoteGame);
		}
		if (s.getKeyChar() == 'j') {
			createLord(remoteGame);
		}
		if (s.getKeyChar() == 'k') {
			createDrache(remoteGame);
		}
		if (s.getKeyChar() == 'l') {
			createHimmelswacht(remoteGame);
		}
		if (s.getKeyChar() == 'm') {
			if (evolution2 == false && exp2 >= 5000) {
				evolution2 = true;
			} else {

			}
		}

		// Per "g" kann der Service gestartet werden und per "f" können die
		// Werte ausgelesen werden.

		if (s.getKeyChar() == 'g' && !remoteGame) {
			service = Service.getService();
			service.start();
		}
		if (s.getKeyChar() == 'f' && !remoteGame) {
			client = RMIClient.getRMIClient();
			client.start();
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

	public void setWerte(LpGoldExp s) {
		WorldHandler.gold = s.gold;
		WorldHandler.gold2 = s.gold2;
		WorldHandler.exp = s.exp;
		WorldHandler.exp2 = s.exp2;
		WorldHandler.lp = s.lp;
		WorldHandler.lp2 = s.lp2;
		Einheit.einheiten = s.einheitenClient;
		Einheit.einheiten2 = s.einheitenServer;
		WorldHandler.evolution2 = s.evolutionClient;
		WorldHandler.evolution1 = s.evolutionServer;

		for (Einheit e : Einheit.einheiten) {
			e.loadImage();
		}

		for (Einheit e : Einheit.einheiten2) {
			e.loadImage();
		}
		// System.out.println("Set werte to " + s.toString());
	}
}
