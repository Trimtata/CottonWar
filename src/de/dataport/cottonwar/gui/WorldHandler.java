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
	
	
	public static ExecutorService executor = Executors.newCachedThreadPool();
	
	public WorldHandler() {
			
		
		JFrame worldhander = new JFrame();
		worldhander.setSize(1200, 700);
		worldhander.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		worldhander.setVisible(true);
		
		

		spielfeld = new Spielfeld();
		spielfeld.setBounds(10, 200, 1590, 870);


		gold =100;
		gold2 = 100;
		exp2 = 100;
		exp = 0;
		w = new World();
		worldhander.setContentPane(w);
		getContentPane().setLayout(null);
		w.setLayout(null);
		w.add(spielfeld);
		
		
		JButton j = new JButton("Krieger");
		JButton k = new JButton("Ritter");
		JButton l = new JButton("Bogenmeister");
		JButton m = new JButton("Ritter");
		JButton n = new JButton("Krieger");
		JButton o = new JButton("Bogenmeister");
		
		n.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (gold2>=25) {
				Einheit e=new Einheit("Krieger", 80, 20, 70, 25, 0, 25, 1, 890, 220, 128, 128, 20,1000);
				gold2 = gold2 - e.getGold();
				Einheit.einheiten.add(e);
				e.setSpielfeld(spielfeld);
				e.ausführen();
				}
			}
		});
		m.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (gold2>=20) {
				Einheit e=new Einheit("Ritter", 200, 12, 10, 20, 0, 15, 1, 890, 220,128, 128, 30,1000);
				gold2 = gold2 - e.getGold();
				Einheit.einheiten.add(e);
				e.setSpielfeld(spielfeld);
				e.ausführen();
			}
			}
		});
		o.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (gold2>=15) {
				Einheit e=new Einheit("Bogenmeister", 100, 20, 10, 15, 0, 10, 1, 890, 220,128, 128, 10,1000);
				gold2 = gold2 - e.getGold();
				Einheit.einheiten.add(e);
				e.setSpielfeld(spielfeld);
				e.ausführen();
				}
			}
		});
		j.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (gold>= 15) {				
				Einheit e=new Einheit("Krieger", 100, 20, 10, 15, 0, 10, 0, 10, 220,128, 128, 20,1000);
				gold = gold - e.getGold();
				Einheit.einheiten2.add(e);
				e.setSpielfeld(spielfeld);
				e.ausführen();
				}
			}
		});
		k.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (gold >=20) {
				Einheit e=new Einheit("Ritter", 200, 12, 10, 20, 0, 15, 0, 10, 220,128, 128, 30,1000);
				gold = gold - e.getGold();
				Einheit.einheiten2.add(e);
				e.setSpielfeld(spielfeld);
				e.ausführen();
				}
			}
		});
		l.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (gold>=30) {
				Einheit e=new Einheit("Bogenmeister", 80, 20, 70, 15, 0, 25, 0, 10, 220,128, 128, 10,1000);
				gold = gold - e.getGold();
				Einheit.einheiten2.add(e);
				e.setSpielfeld(spielfeld);
				e.ausführen();
				}
			}
		});
		
		
		j.setBounds(10, 10, 80, 20);
		k.setBounds(95, 10, 80, 20);
		l.setBounds(180, 10, 80, 20);
		o.setBounds(1090, 10, 80, 20);
		m.setBounds(1000, 10, 80, 20);
		n.setBounds(910, 10, 80, 20);
		
				
		w.add(j);
		w.add(k);
		w.add(l);
		w.add(o);
		w.add(m);
		w.add(n);
		
		JLabel r = new JLabel(gold + "");
		
		r.setBounds(270, 13, 46, 14);
		w.add(r);
		
		JLabel r2 = new JLabel(gold2 +"");
		r2.setBounds(854, 13, 46, 14);
		w.add(r2);

		
		
		Timer timer = new Timer(1, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				spielfeld.repaint();
			}
		});
		timer.start();
		
		Timer timer2 = new Timer(4000, new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			gold = gold + 10;
			gold2 = gold2 +10;
		}
	});
	timer2.start();
		
	}

	public int wievielGold1() {
		
		return gold;
		
	}
	public int wievielGold2() {
		
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
