package de.dataport.cottonwar.gui;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.FlowLayout;

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

		
		w = new World(panelSpielfeld);
		worldhander.setContentPane(w);
		getContentPane().setLayout(null);
		w.setLayout(null);
		w.add(panelSpielfeld);
		
		JButton j = new JButton("Swag");
		j.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Einheit e=new Einheit("herbert", 0, 0, 0, 0, 0, 0, 0, 0, 20, 80,100,100);
				e.setSpielfeld(panelSpielfeld);
				e.ausführen();
			}
		});
		j.setBounds(10, 11, 89, 23);
		
				
		w.add(j);
		
		
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
