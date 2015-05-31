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
		worldhander.setSize(800, 600);
		worldhander.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		worldhander.setVisible(true);
		

		panelSpielfeld = new JPanel();
		panelSpielfeld.setBounds(10, 87, 764, 464);

		
		w = new World();
		worldhander.setContentPane(w);
		getContentPane().setLayout(null);
		w.setLayout(null);
		w.add(panelSpielfeld);
		
		
		JButton j = new JButton("Schläger");
		JButton k = new JButton("Schütze");
		JButton l = new JButton("Panzer");
		final JButton josef = new JButton("Spiel starten");
		
		
		j.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Einheit e=new Einheit("herbert", 0, 0, 0, 0, 0, 0, 0, 0, 10, 220,100,100);
				Einheit.einheiten.add(e);
				e.setSpielfeld(panelSpielfeld);
				e.ausführen();
			}
		});
		k.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Einheit e=new Einheit("herbert", 0, 0, 0, 0, 0, 0, 0, 0, 10, 220,100,100);
				Einheit.einheiten.add(e);
				e.setSpielfeld(panelSpielfeld);
				e.ausführen();
			}
		});
		l.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Einheit e=new Einheit("herbert", 0, 0, 0, 0, 0, 0, 0, 0, 10, 220,100,100);
				Einheit.einheiten.add(e);
				e.setSpielfeld(panelSpielfeld);
				e.ausführen();
			}
		});
		josef.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Einheit e =new Einheit("herbert", 0, 0, 0, 0, 0, 0, 0, 0, 10, 220,100,100);
				e.setSpielfeld(panelSpielfeld);
				josef.setVisible(false);
				e.zeichnen();
			}
		});
		
		j.setBounds(10, 10, 80, 20);
		k.setBounds(95, 10, 80, 20);
		l.setBounds(180, 10, 80, 20);
		josef.setBounds(340, 40, 110, 20);
		
				
		w.add(j);
		w.add(k);
		w.add(l);
		w.add(josef);
		
		
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
