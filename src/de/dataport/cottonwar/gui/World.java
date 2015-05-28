package de.dataport.cottonwar.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JViewport;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import de.dataport.cottonwar.objekte.Einheit;
import de.dataport.cottonwar.objekte.Schlaeger;

import javax.swing.JButton;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Timer;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class World extends JPanel implements ActionListener{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JPanel panel;
	GameObject a = new GameObject();

	/**
	 * Launch the application.
	 */

	public void ausführen() {
		
		Timer timer = new Timer(10, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				a.x = a.x +1;
				repaint();
			}
		});
		timer.start();
		
		}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.drawImage(a.i, a.x, a.y, 200, 300, null);
	}

	public World(JFrame eigentümer) {
		List<GameObject> yolo = new ArrayList<GameObject>();
		yolo.add(a);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setVisible(true);
		
		JButton j = new JButton("Sch");
		j.setBounds(10, 10, 50, 50);
		//j.addActionListener(this);
		j.setVisible(true);
		panel.add(j);
		

		

		
	
//		this.ausführen();

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
	public void actionPerformed(ActionEvent e) {
		this.ausführen();
	}
}
