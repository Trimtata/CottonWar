package de.dataport.cottonwar.gui;

import javax.swing.JButton;
import javax.swing.JFrame;

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

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class WorldHandler extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8853228346248816103L;
	World w;
	JPanel panelSpielfeld;
	public WorldHandler() {
		JFrame worldhander = new JFrame();
		worldhander.setSize(1200, 700);
		worldhander.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		worldhander.setVisible(true);
		

		panelSpielfeld = new JPanel();
		panelSpielfeld.setBounds(10	, 200, 1590, 870);

		
		w = new World();
		worldhander.setContentPane(w);
		getContentPane().setLayout(null);
		w.setLayout(null);
		w.add(panelSpielfeld);
		
		
		JButton j = new JButton("Krieger");
		JButton k = new JButton("Schütze");
		JButton l = new JButton("Panzer");
		JButton m = new JButton("Schütze");
		JButton n = new JButton("Schütze");
		JButton o = new JButton("Krieger");
		final JButton josef = new JButton("Spiel starten");
		
		n.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Einheit e=new Einheit("Bogenmeister", 80, 20, 70, 15, 0, 25, 1, 890, 220,100,100);
				Einheit.einheiten.add(e);
				e.setSpielfeld(panelSpielfeld);
				e.ausführen();
			}
		});
		m.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Einheit e=new Einheit("Ritter", 200, 12, 10, 20, 0, 15, 1, 890, 220,100,100);
				Einheit.einheiten.add(e);
				e.setSpielfeld(panelSpielfeld);
				e.ausführen();
			}
		});
		o.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Einheit e=new Einheit("Krieger", 100, 20, 10, 15, 0, 10, 1, 890, 220,100,100);
				Einheit.einheiten.add(e);
				e.setSpielfeld(panelSpielfeld);
				e.ausführen();
			}
		});
		j.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Einheit e=new Einheit("Krieger", 100, 20, 10, 15, 0, 10, 0, 10, 220,100,100);
				Einheit.einheiten.add(e);
				e.setSpielfeld(panelSpielfeld);
				e.ausführen();
			}
		});
		k.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Einheit e=new Einheit("Ritter", 200, 12, 10, 20, 0, 15, 0, 10, 220,100,100);
				Einheit.einheiten.add(e);
				e.setSpielfeld(panelSpielfeld);
				e.ausführen();
			}
		});
		l.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Einheit e=new Einheit("Bogenmeister", 80, 20, 70, 15, 0, 25, 0, 10, 220,100,100);
				Einheit.einheiten.add(e);
				e.setSpielfeld(panelSpielfeld);
				e.ausführen();
			}
		});
		josef.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Einheit e =new Einheit("herbert", 0, 0, 0, 0, 0, 0, 0, 10, 220,100,100);
				e.setSpielfeld(panelSpielfeld);
				josef.setVisible(false);
				e.zeichnen();
			}
		});
		
		j.setBounds(10, 10, 80, 20);
		k.setBounds(95, 10, 80, 20);
		l.setBounds(180, 10, 80, 20);
		josef.setBounds(500, 40, 110, 20);
		o.setBounds(1090, 10, 80, 20);
		m.setBounds(1000, 10, 80, 20);
		n.setBounds(910, 10, 80, 20);
		
				
		w.add(j);
		w.add(k);
		w.add(l);
		w.add(josef);
		w.add(o);
		w.add(m);
		w.add(n);
		
		
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
